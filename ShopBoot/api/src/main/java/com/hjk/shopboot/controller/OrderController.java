package com.hjk.shopboot.controller;
import java.util.List;

import com.hjk.model.Orders;
import com.hjk.shopboot.service.OrderService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ApiOperation(value="체크아웃 페이지")
    @GetMapping(value = "/checkout")
    public String checkOutView(Model model) {
        List<Orders> orderResponse = orderService.getMyOrderAllON();
        model.addAttribute("order", orderResponse);
        model.addAttribute("orderTotal", orderResponse.stream().mapToInt(o->(int) o.getTotal()).sum());
        model.addAttribute("size", orderResponse.size());
        return "order/checkout";
    }
}
