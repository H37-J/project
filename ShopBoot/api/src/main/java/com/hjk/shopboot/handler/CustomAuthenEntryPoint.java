package com.hjk.shopboot.handler;

import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
    AuthenticationException authException) throws IOException, ServletException {
        request.setAttribute("notLoginMsg", "로그인 후 가능한 페이입니다");
        request.getRequestDispatcher("/notLogin").forward(request, response);
    }


}
