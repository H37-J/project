package com.hjk.shopboot.handler;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hjk.shopboot.utils.session.SessionUtils;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        if (exception.getMessage().equals("Bad credentials")){
            SessionUtils.setUserNull();                               
            request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다!");
        }
        else{
            // 아이디 틀릴 경우 or  이미 탈퇴된 유저일 경우
            request.setAttribute("errorMsg", exception.getMessage());
        }

        request.getRequestDispatcher("/loginFailure").forward(request, response);
    }

   
    
}
