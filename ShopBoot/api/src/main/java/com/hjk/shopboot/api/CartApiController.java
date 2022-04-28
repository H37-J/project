package com.hjk.shopboot.api;

import java.util.List;

import com.hjk.model.Cart;
import com.hjk.shopboot.service.CartService;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartApiController {

    private final CartService cartService;

    @ApiOperation(value="모든장바구니 조회 API")
    @RequestMapping(value="getMyCartAll",method=RequestMethod.GET)
    public ResponseEntity<List<Cart>> getCartAll(){
        return ResponseEntity.ok(cartService.getMyCartAll());
    }

    @ApiOperation(value="장바구니 저장 API")
    @RequestMapping(value="save",method=RequestMethod.POST)
    public void cartSave(@RequestParam(value="id") long id){
        cartService.cartSave(id);
    }

    @ApiOperation(value="장바구니 삭제 API")
    @RequestMapping(value="delete",method=RequestMethod.DELETE)
    public void delete(@RequestParam(value="id") long id){
        cartService.deleteCart(id);
    }

}
