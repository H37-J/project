package com.hjk.shopboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.hjk.dto.UserRequestDto;
import com.hjk.model.Product;
import com.hjk.shopboot.service.ProductService;
import com.hjk.shopboot.service.UserService;

import com.hjk.shopboot.utils.etc.ConvertUtils;
import com.hjk.shopboot.utils.etc.RandomUtils;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final UserService userService;
    Product recommandProduct=null;
    Product coming=null;

    @ApiOperation(value="메인 페이지")
    @GetMapping("/")
    public String mainView(Model model) {
        // userService.login(UserRequestDto.LoginRequestDto.builder().accountId("hjk").password("123").build()); //테스트용 자동로그인

        List<Product> productList=productService.getAll();
        List<Product> newList= productList.stream().filter(p->p.getStatus().equals("NEW")).collect(Collectors.toList());
        List<Product> comingList= productList.stream().filter(p->p.getStatus().equals("COMING")).collect(Collectors.toList());
        if(comingList.size()>0) model.addAttribute("coming",comingList.get(RandomUtils.getRandom(comingList.size())));
        if(productList.size()>0)    model.addAttribute("recommandProduct", productList.get(RandomUtils.getRandom(productList.size())));  // 랜덤으로 추천상품
        productList = ConvertUtils.convertDisplay(productList,9); // 최신 9개만 출력\
        newList = ConvertUtils.convertDisplay(newList,9); // 최신 9개만 출력\

        model.addAttribute("productList", productList);
        model.addAttribute("newList", newList);

        return "shop/shop";
    }


}
