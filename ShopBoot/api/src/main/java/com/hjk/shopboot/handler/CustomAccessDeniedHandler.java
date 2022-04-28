package com.hjk.shopboot.handler;

import org.springframework.security.web.access.AccessDeniedHandler;
import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        request.setAttribute("AccessErrorMsg", "접근 권한이 없습니다");
        request.getRequestDispatcher("/denied").forward(request, response);
    }

}
