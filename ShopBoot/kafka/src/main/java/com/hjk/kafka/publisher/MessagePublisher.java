package com.hjk.kafka.publisher;


import com.hjk.kafka.channel.RegisterSuccessOutputChannel;

import com.hjk.model.User;
import org.springframework.stereotype.Component;
import org.springframework.integration.support.MessageBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MessagePublisher {

    private final RegisterSuccessOutputChannel registerSuccessOutputChannel;

    public void publishRegisterSuccessMessage(User user) {
        registerSuccessOutputChannel.outputChannel().send(MessageBuilder.withPayload(user).build());
    }

}
