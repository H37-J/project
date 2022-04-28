package com.hjk.shopboot.controller;

import java.util.stream.Collectors;

import com.hjk.dto.OrderRequestDto;
import com.hjk.dto.PageDto;
import com.hjk.dto.UserResponseDto;
import com.hjk.model.Likes;
import com.hjk.model.Orders;
import com.hjk.model.Product;
import com.hjk.model.Review;
import com.hjk.shopboot.service.*;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class AjaxController {

    private final ProductService productService;
    private final UserService userService;
    private final CartService cartService;
    private final OrderService orderService;
    private final ReviewService reviewService;
    private final LikesService likesService;
    Page<Product> product = null;
    Page<Orders> orders = null;
    PageDto<UserResponseDto> user = null;

    // 사용자
    @ApiOperation(value = "비동기 사용자검색")
    @RequestMapping(value = "/asyncUserSearch")
    public String umView(Model model,
            @PageableDefault(page = 0, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable page,
            @RequestParam(value = "keyword", required = false) String keyword) {
        model.addAttribute("User", userService.getAllUserPageSearch(page, keyword));
        model.addAttribute("keyword", keyword);
        return "admin/admin :: #usearch";
    }

    // 사용자
    @ApiOperation(value = "비동기 휴먼계정")
    @RequestMapping(value = "/asyncHumanSearch")
    public String hmView(Model model,
            @PageableDefault(page = 0, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable page,
            @RequestParam(value = "keyword", required = false) String keyword) {
        model.addAttribute("User", userService.getAllUserDeletedPageSearch(page, keyword));
        model.addAttribute("keyword", keyword);
        return "admin/human :: #usearch";
    }

    // 카트
    @ApiOperation(value = "비동기 장바구니 저장")
    @RequestMapping("asyncCartSave")
    public String asyncCartSave(@RequestParam(value = "id") long id) {
        cartService.cartSave(id);
        return "template/header :: .cartdiv";
    }

    @ApiOperation(value = "비동기 장바구니 삭제")
    @RequestMapping("asyncCartDelete")
    public String asyncCartDelete(@RequestParam(value = "id") long id) {
        cartService.deleteCart(id);
        return "template/header::.cartdiv";
    }

    @ApiOperation(value = "비동기 장바구니 삭제(장바구니페이지)")
    @RequestMapping("asyncCartDeleteCart")
    public String asyncCartDeleteCart() {
        return "user/wishlist :: #cartdiv";
    }

    // 상품
    @ApiOperation(value = "비동기 상품삭제")
    @RequestMapping("asyncProductDelete")
    public String asyncProductDelete(Model model,
            @PageableDefault(page = 0, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "id", required = false) long id) {
        productService.delete(id);
        if (search != null) {
            model.addAttribute("search", search);
            model.addAttribute("keyword", keyword);
            product = productService.getAll(pageable, keyword, search);
        } else {
            product = productService.getAll(pageable);
        }
        List<Product> productList = product.stream().collect(Collectors.toList());
        PageDto<Product> page = PageDto.of(product, productList);
        model.addAttribute("product", productList);
        model.addAttribute("page", page);

        return "admin/productManage :: #pdiv";
    }

    @ApiOperation(value = "비동기 상품검색")
    @RequestMapping(value = "/asyncSearch")
    public String pmView(Model model,
            @PageableDefault(page = 0, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "keyword", required = false) String keyword) {
        product = productService.getAll(pageable, keyword, "title");
        List<Product> productList = product.stream().collect(Collectors.toList());
        int size = productList.size();
        PageDto<Product> page = PageDto.of(product, productList);

        model.addAttribute("product", productList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("search", "title");
        model.addAttribute("keyword", keyword);
        return "admin/productManage :: #psearch";
    }

    @ApiOperation(value = "비동기 상품필터링(가격)")
    @RequestMapping(value = "/asynFilterPrice")
    public String prViewPrice(Model model,
            @PageableDefault(page = 0, size = 9, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "priceMin", required = false) int priceMin,
            @RequestParam(value = "priceMax", required = false) int priceMax,
            @RequestParam(value = "cm", required = false) String cm,
            @RequestParam(value = "cs", required = false) String cs,
            @RequestParam(value = "size", required = false) String size) {
        product = productService.getAllFilterPrice(pageable, cm, cs, field, priceMin, priceMax, size);
        List<Product> productList = product.stream().collect(Collectors.toList());
        PageDto<Product> page = PageDto.of(product, productList);
        int pSize = productList.size();

        model.addAttribute("product", productList);
        model.addAttribute("page", page);
        model.addAttribute("size", pSize);
        model.addAttribute("cm", cm);
        model.addAttribute("cs", cs);
        model.addAttribute("search", "title");
        model.addAttribute("field", field);
        return "shop/product :: #pFilter";
    }

    // 주문
    @ApiOperation(value = "비동기 주문삭제")
    @RequestMapping("/asyncOrderDelete")
    public String asyncOrderDelete(Model model,
            @PageableDefault(page = 0, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "id", required = false) long id) {
        orderService.cancelOrder(id);
        if (search != null) {
            model.addAttribute("search", search);
            model.addAttribute("keyword", keyword);
            orders = orderService.getAllPage(pageable);
        } else {
            orders = orderService.getAllPage(pageable);
        }
        List<Orders> orderList = orders.stream().collect(Collectors.toList());
        PageDto<Orders> page = PageDto.of(orders, orderList);
        model.addAttribute("order", orderList);
        model.addAttribute("page", page);

        return "user/myOrder :: #pdiv";
    }

    @ApiOperation(value = "비동기 주문검색")
    @RequestMapping(value = "/asyncOrderSearch")
    public String osView(Model model,
            @PageableDefault(page = 0, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "keyword", required = false) String keyword) {
        orders = orderService.getAllPageSearch(pageable, keyword, "title");
        List<Orders> orderList = orders.stream().collect(Collectors.toList());
        int size = orderList.size();
        PageDto<Orders> page = PageDto.of(orders, orderList);

        model.addAttribute("order", orderList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("search", "title");
        model.addAttribute("keyword", keyword);
        return "admin/myOrder :: #psearch";
    }

    // 체크아웃
    @ApiOperation(value = "체크아웃 포인트 적용")
    @RequestMapping(value = "/asyncOrderPoint")
    public String cpView(Model model, @RequestBody OrderRequestDto orderRequest) {
        orderService.orderPointApply(orderRequest);
        List<Orders> orderResponse = orderService.getMyOrderAllON();
        int priceSum = orderResponse.stream().mapToInt(o -> (int) o.getPrice()).sum();
        int stockSum = orderResponse.stream().mapToInt(o -> (int) o.getStock()).sum();

        model.addAttribute("order", orderResponse);
        model.addAttribute("originalTotal", priceSum * stockSum);
        model.addAttribute("orderTotal", orderResponse.stream().mapToInt(o -> (int) o.getTotal()).sum());
        model.addAttribute("size", orderResponse.size());

        return "order/checkout :: #pointView";
    }

    // 리뷰
    @ApiOperation(value = "비동기 리뷰 삭제")
    @RequestMapping("asyncReviewDelete")
    public String asyncReviewDelete(Model model, @RequestParam(value = "id") long id) {
        reviewService.reviewDelete(id);
        model.addAttribute("product", productService.getId(id));
        model.addAttribute("review", reviewService.getReview(id));
        return "shop/productDetail :: #reviewDiv";
    }

    // 좋아요 업데이트
    @ApiOperation(value = "비동기 좋아요 업데이트")
    @RequestMapping("asyncReviewLikePlusUpdate")
    public String asyncReviewLikePlusUpdate(Model model, @RequestParam(value = "id") long id) {
        model.addAttribute("review", reviewService.likePlus(id));
        return "shop/productDetail :: #likeDiv";
    }

    @ApiOperation(value = "비동기 좋아요 업데이트")
    @RequestMapping("asyncReviewLikeMinusUpdate")
    public String asyncReviewLikeMinusUpdate(Model model, @RequestParam(value = "id") long id) {
        model.addAttribute("review", reviewService.likeMinus(id));

        return "shop/productDetail :: #likeDiv";
    }

    @ApiOperation(value = "사용자 좋아요 기록 저장")
    @RequestMapping(value = "asyncLikesSave", method = RequestMethod.POST)
    public String asyncLikesSave(Model model, @RequestBody Likes likes) {
        likesService.likesSave(likes);
        model.addAttribute("likes", likesService.getMyLikesAll());
        return "shop/productDetail :: #likeDiv";
    }

    @ApiOperation(value = "사용자 좋아요 기록 취소")
    @RequestMapping(value = "asyncLikesCancel", method = RequestMethod.POST)
    public String asyncLikesCancel(Model model, @RequestBody Likes likes) {
        likesService.likeCancel(likes);
        model.addAttribute("likes", likesService.getMyLikesAll());
        return "shop/productDetail :: #likeDiv";
    }

}
