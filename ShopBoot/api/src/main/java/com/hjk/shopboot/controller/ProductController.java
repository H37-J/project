package com.hjk.shopboot.controller;

import com.hjk.dto.UserResponseDto;
import io.swagger.annotations.ApiOperation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.hjk.dto.PageDto;
import com.hjk.model.Product;
import com.hjk.shopboot.service.LikesService;
import com.hjk.shopboot.service.ProductService;
import com.hjk.shopboot.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;
    private final LikesService likesService;

    @ApiOperation(value="상품상세 페이지 조회")
    @GetMapping(value = "/productDetail/{id}")
    public String pdView(Model model, @PathVariable long id, HttpSession httpSession) {
        model.addAttribute("product", productService.getId(id));
        model.addAttribute("review",reviewService.getReview(id));
        model.addAttribute("likes",null);
        UserResponseDto user=(UserResponseDto) httpSession.getAttribute("User");
        if(user!=null)model.addAttribute("likes",likesService.getMyLikesAll());

        return "shop/productDetail";
    }

    @ApiOperation(value="남성 상품 카테고리별 분리 1차")
    @GetMapping("/product/{cm}")
    public String cateOne(Model model,@PathVariable String cm,
                          @PageableDefault(page = 1, size = 9, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {

        productCount(model, cm,"");
        Page<Product> product=productService.getProductCategory(pageable, cm);
        List<Product> productList=product.toList();
        PageDto<Product> page=PageDto.of(product,productList);
        model.addAttribute("product", productList);
        model.addAttribute("page",page);
        return "shop/product";
    }

    @ApiOperation(value="남성 상품 카테고리별 분리 1,2차")
    @GetMapping("/product/{cm}/{cs}")
    public String cateTwo(Model model,@PathVariable String cm,@PathVariable String cs,
                          @PageableDefault(page = 1, size = 9, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        productCount(model,cm,cs);
        Page<Product> product=productService.getProductCategory(pageable, cm, cs);
        List<Product> productList=product.toList();
        PageDto<Product> page=PageDto.of(product,productList);
        model.addAttribute("product", productList);
        model.addAttribute("page",page);
        return "shop/product";
    }

    private void productCount(Model model,String cm,String cs) {
        model.addAttribute("cm",cm);
        model.addAttribute("cs",cs);
        if (cm.equals("남성") || cm.equals("여성")) {
            model.addAttribute("AllSize",productService.getProductCategory(cm).size());
            model.addAttribute("cateFirst", productService.getProductCategory(cm).stream().filter(p -> p.getCategory_sub().equals("상의")).count());
            model.addAttribute("cateSecond", productService.getProductCategory(cm).stream().filter(p -> p.getCategory_sub().equals("하의")).count());
            model.addAttribute("cateThird", productService.getProductCategory(cm).stream().filter(p -> p.getCategory_sub().equals("코트")).count());

            if(cs==""){
                model.addAttribute("sizeS", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("S")).count());
                model.addAttribute("sizeM", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("M")).count());
                model.addAttribute("sizeL", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("L")).count());
                model.addAttribute("sizeXL", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("XL")).count());
            }else{
                model.addAttribute("sizeS", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("S")).count());
                model.addAttribute("sizeM", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("M")).count());
                model.addAttribute("sizeL", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("L")).count());
                model.addAttribute("sizeXL", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("XL")).count());
            }
        }else{
            model.addAttribute("AllSize",productService.getProductCategory(cm).size());
            model.addAttribute("cateFirst", productService.getProductCategory(cm).stream().filter(p -> p.getCategory_sub().equals("시계")).count());
            model.addAttribute("cateSecond", productService.getProductCategory(cm).stream().filter(p -> p.getCategory_sub().equals("장갑")).count());
            model.addAttribute("cateThird", productService.getProductCategory(cm).stream().filter(p -> p.getCategory_sub().equals("지갑")).count());
       
            if(cs==""){
                model.addAttribute("sizeS", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("S")).count());
                model.addAttribute("sizeM", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("M")).count());
                model.addAttribute("sizeL", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("L")).count());
                model.addAttribute("sizeXL", productService.getProductCategory(cm).stream().filter(p-> p.getSize().trim().equals("XL")).count());
            }else{
                model.addAttribute("sizeS", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("S")).count());
                model.addAttribute("sizeM", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("M")).count());
                model.addAttribute("sizeL", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("L")).count());
                model.addAttribute("sizeXL", productService.getProductCategory(cm,cs).stream().filter(p-> p.getSize().trim().equals("XL")).count());
            }
        }
    }
}
