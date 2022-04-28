package com.hjk.shopboot.api;

import java.util.List;

import com.hjk.model.Orders;
import com.hjk.shopboot.service.OrderService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import io.swagger.annotations.ApiOperation;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;


    @ApiOperation(value="내 주문정보 조회(사용자)")
    @RequestMapping(value="myOrders",method=RequestMethod.GET)
    public ResponseEntity<Page<Orders>> getMyOrders(@PageableDefault(page = 1, size = 10, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.ok(orderService.getAllPage(pageable));
    }

    @ApiOperation(value="모든주문조회 API(관리자)")
    @RequestMapping(value="getAll",method=RequestMethod.GET)
    public ResponseEntity<List<Orders>> getAll(Model model){
        return ResponseEntity.ok(orderService.getAll());
    }

    @ApiOperation(value="체크아웃에서 상품 결제 진행중으로 임시저장 API")
    @RequestMapping(value="orderSave",method = RequestMethod.POST)
    public void orderSave(@RequestBody List<Orders> orderRequest){
        orderService.orderStatusOn(orderRequest);
    }

    @ApiOperation(value="진행중 상품 삭제 API")
    @RequestMapping(value="orderDeleteOn",method=RequestMethod.DELETE)
    public void orderDelete(){
        orderService.deleteOn();
    }

    @ApiOperation(value="상품결제완료 API")
    @RequestMapping(value="orderComplete",method=RequestMethod.POST)
    public void orderComplete(){
        orderService.orderComplete();
    }
}


