package com.hjk.mailserver.service;


import com.hjk.dto.UserRequestDto;
import com.hjk.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

@Slf4j
@RequiredArgsConstructor
@Service
public class MailStreamService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    private String host="localhost:8080";

    public void sendPaymentSuccessMail(UserRequestDto.SignRequestDto user) {

        Context context = getPaymentSuccessMailContext(user);

        String message = templateEngine.process("register-success-mail", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setSubject("H37-J Market 회원가입 관련 메일입니다.");
            mimeMessageHelper.setText(message, true);
            javaMailSender.send(mimeMessage);
            log.info("메일 전송에 성공했습니다.");
        }
        catch(Exception e){
            log.error("메일 전송에 실패했습니다.", e);
        }
    }

    private Context getPaymentSuccessMailContext(UserRequestDto.SignRequestDto user) {
        Context context = new Context();
        context.setVariable("buyerName", "호종규");
        context.setVariable("message", "H-Market에 회원가입 해주셔서 진심으로 감사 합니다");
        context.setVariable("accountId", user.getAccountId());
        context.setVariable("name", user.getName());
        context.setVariable("email", user.getEmail());
        context.setVariable("host", "localhost:8080");

        return context;
    }
}
