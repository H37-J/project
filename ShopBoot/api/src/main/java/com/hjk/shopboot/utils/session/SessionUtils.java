package com.hjk.shopboot.utils.session;

import javax.servlet.http.HttpServletRequest;

import com.hjk.dto.UserResponseDto;
import com.hjk.model.Cart;
import com.hjk.model.User;

import com.hjk.shopboot.exception.CustomException;
import com.hjk.shopboot.exception.UserException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.*;

public class SessionUtils {
    
    static HttpServletRequest request;

    public static void setUser(UserResponseDto userResponse){
        request=getHttpRequest();
        request.getSession().setAttribute("User",userResponse);
    }

    public static UserResponseDto getUser(){
        request=getHttpRequest();
        UserResponseDto userResponse=(UserResponseDto)request.getSession().getAttribute("User");
        if(userResponse==null) throw new CustomException(UserException.LOGIN_INFORMATION_NOT_FOUND);
        return userResponse;
    }

    public static User getUserEntity(){
        request=getHttpRequest();
        UserResponseDto userResponse=(UserResponseDto)request.getSession().getAttribute("User");
        if(userResponse==null) throw new CustomException(UserException.LOGIN_INFORMATION_NOT_FOUND);
        return userResponse.toEntity();
    }

    public static void setUserNull(){
        request=getHttpRequest();
        request.getSession().setAttribute("User",null);
    }

    public static void setCartSize(int cartSize){
        request=getHttpRequest();
        request.getSession().setAttribute("cartSize",cartSize);
    }

    public static void setAllCart(List<Cart> cartList){
        request=getHttpRequest();
        request.getSession().setAttribute("cartList",cartList);
    }

    public static void setCartTwo(List<Cart> cartTwo){
        request=getHttpRequest();
        request.getSession().setAttribute("cart",cartTwo);
    }

    public static void setCartTwoSum(int cartTwoSum){
        request=getHttpRequest();
        request.getSession().setAttribute("sum",cartTwoSum);
    }

    public static HttpServletRequest getHttpRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    
}
