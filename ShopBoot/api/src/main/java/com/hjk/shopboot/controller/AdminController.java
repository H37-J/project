package com.hjk.shopboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.hjk.model.Product;
import com.hjk.dto.PageDto;
import com.hjk.dto.UserRequestDto;
import com.hjk.dto.UserResponseDto;
import com.hjk.model.Product;
import com.hjk.shopboot.service.ProductService;
import com.hjk.shopboot.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;
    private final UserService userService;
    PageDto<UserResponseDto> user=null;
    Page<Product> product = null;

    @ApiOperation(value="유저관리 페이지")
    @GetMapping("/admin")
    public String adminView(Model model,@PageableDefault(page = 1, size = 10, sort = "createAt", direction = Sort.Direction.DESC)Pageable page,
    @RequestParam(value="keyword",required = false)String keyword) {
        user=userService.getAllUserPage(page);
        if(keyword!=null) user=userService.getAllUserPageSearch(page, keyword);
        model.addAttribute("User",user);
        model.addAttribute("keyword",keyword);
        return "admin/admin";
    }

    @ApiOperation(value="휴먼계전 관리 페이지")
    @GetMapping("/admin/human")
    public String humanView(Model model,@PageableDefault(page = 1, size = 10, sort = "createAt", direction = Sort.Direction.DESC)Pageable page,
                            @RequestParam(value="keyword",required = false)String keyword) {
        user=userService.getAllUserDeletedPage(page);
        if(keyword!=null) user=userService.getAllUserDeletedPageSearch(page, keyword);
        model.addAttribute("User",user);
        model.addAttribute("keyword",keyword);
        return "admin/human";
    }

    @ApiOperation(value="상품등록")
    @GetMapping("/admin/productUpload")
    public String puView(Model model) {
        return "admin/productUpload";
    }

    @ApiOperation(value="상품 수정")
    @GetMapping(value = "admin/productModify/{id}")
    public String pdView(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.getId(id));
        return "admin/productModify";
    }

    @ApiOperation(value="상품관리")
    @GetMapping(value = "/admin/productManage")
    public String pmView(Model model,
                         @PageableDefault(page = 1, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam(value = "search", required = false) String search,
                         @RequestParam(value = "keyword", required = false) String keyword) {
        product = productService.getAll(pageable);
        if (search != null) {
            model.addAttribute("search", search);
            model.addAttribute("keyword", keyword);
            product = productService.getAll(pageable, keyword, search);
        } 
        List<Product> productList = product.stream().collect(Collectors.toList());
        PageDto<Product> page = PageDto.of(product, productList);
        model.addAttribute("product", productList);
        model.addAttribute("size",productList.size());
        model.addAttribute("page", page);
        return "admin/productManage";
    }
}
