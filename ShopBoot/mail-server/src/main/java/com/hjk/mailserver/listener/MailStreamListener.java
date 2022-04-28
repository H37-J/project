package com.hjk.mailserver.listener;

import com.hjk.dto.UserRequestDto;
import com.hjk.kafka.channel.RegisterSuccessMailInputChannel;
import com.hjk.mailserver.service.MailStreamService;
import com.hjk.model.User;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@EnableBinding(RegisterSuccessMailInputChannel.class)
@RequiredArgsConstructor
@Component
@Slf4j
public class MailStreamListener {

    private final MailStreamService mailStreamService;


    @StreamListener(RegisterSuccessMailInputChannel.REGISTER_SUCCESS_MAIL_CONSUMER)
    public void registerSuccessMail(UserRequestDto.SignRequestDto user){
        mailStreamService.sendPaymentSuccessMail(user);
    }

}
