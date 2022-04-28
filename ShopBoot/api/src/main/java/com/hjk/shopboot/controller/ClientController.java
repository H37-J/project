package com.hjk.shopboot.controller;


import com.hjk.kafka.channel.RegisterSuccessOutputChannel;
import com.hjk.model.Orders;
import com.hjk.model.User;
import com.hjk.dto.PageDto;
import com.hjk.kafka.publisher.MessagePublisher;
import com.hjk.shopboot.service.OrderService;
import com.hjk.enums.Search;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final OrderService orderService;

    @ApiOperation(value = "로그인 페이지")
    @GetMapping("/login")
    public String loginView() {
        return "user/login";
    }

    @ApiOperation(value = "로그인 실패시")
    @PostMapping("/loginFailure")
    public String loginFailure() {
        return "user/login";
    }

    @ApiOperation(value = "중복 로그인 방지")
    @GetMapping("/duplicated-login")
    public String duplicatedLogin(RedirectAttributes rttr) {
        rttr.addFlashAttribute("duplicatedLogin", "다른 곳에서 로그인 하였습니다.");
        return "redirect:/";
    }


    @ApiOperation(value = "인증 에러")
    @GetMapping("/notLogin")
    public String notLogin(RedirectAttributes rttr) {
        rttr.addFlashAttribute("notLoginMsg", "로그인 후 이용 가능한 페이지 입니다.");
        return "redirect:/login";
    }

    @ApiOperation(value = "관리자 페이지 인가 에러")
    @GetMapping("/denied")
    public String accessDenied(RedirectAttributes rttr) {
        rttr.addFlashAttribute("duplicatedLogin", "접근 권한이 없습니다.");
        return "redirect:/";
    }

    @ApiOperation(value = "로그아웃")
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // remember-me 쿠키 삭제
        new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY)
                .logout(request, response, authentication);

        new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/";
    }

    @ApiOperation(value = "회원가입 페이지")
    @GetMapping("/register")
    public String registerView() {
        return "user/register";
    }

    @ApiOperation(value = "마이페이지")
    @GetMapping("/user/profile")
    public String profileView() {
        return "user/profile";
    }

    @ApiOperation(value = "장바구니")
    @GetMapping("/user/wishlist")
    public String wishlistView() {
        return "user/wishlist";
    }

    @ApiOperation(value = "나의 카드정보")
    @GetMapping("/user/myCard")
    public String cardView() {
        return "user/myCard";
    }

    @ApiOperation(value = "나의주문")
    @GetMapping("/user/myOrder")
    public String myOrder(Model model,
            @PageableDefault(page = 1, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "search", required = false) Search search,
            @RequestParam(value = "keyword", required = false) String keyword) {
        Page<Orders> pageOrders = null;
        if (search != null) {
            model.addAttribute("search", search);
            model.addAttribute("keyword", keyword);
            pageOrders = orderService.getAllPageSearch(pageable, keyword, search);
        } else {
            pageOrders = orderService.getAllPage(pageable);
        }
        List<Orders> orderList = pageOrders.toList();
        PageDto<Orders> page = PageDto.of(pageOrders, orderList);

        model.addAttribute("order", orderList);
        model.addAttribute("page", page);
        model.addAttribute("size", orderList.size());
        return "user/myOrder";
    }
}
