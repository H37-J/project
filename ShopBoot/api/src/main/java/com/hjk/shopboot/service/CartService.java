package com.hjk.shopboot.service;

import java.util.List;

import com.hjk.dto.UserResponseDto;
import com.hjk.model.Cart;
import com.hjk.shopboot.respository.CartRepository;
import com.hjk.shopboot.utils.etc.ConvertUtils;
import com.hjk.shopboot.utils.session.SessionUtils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    
    private final CartRepository cartRepository;
    private final ProductService productService;

    //내 장바구니 조회
    public List<Cart> getMyCartAll(){
        List<Cart> cartList =cartRepository.findAllByUser(SessionUtils.getUserEntity());

        SessionUtils.setAllCart(cartList);
        SessionUtils.setCartTwo(ConvertUtils.convertDisplay(cartList, 2));
        SessionUtils.setCartTwoSum(ConvertUtils.convertDisplay(cartList, 2).stream().mapToInt(c -> (int) c.getProduct().getPrice()).sum());
        SessionUtils.setCartSize(cartList.size());
        return cartList;
    }

    //내 장바구니 삭제
    public void deleteCart(long id){
        cartRepository.deleteById(id);
        getMyCartAll();
    }

    //내 장바구니 저장
    public void cartSave(long id) {
        UserResponseDto userResponse=SessionUtils.getUser();
        Cart cart=Cart.builder().user(userResponse.toEntity()).product(productService.getId(id)).build();
        cartRepository.save(cart);
        getMyCartAll();
    }
}
