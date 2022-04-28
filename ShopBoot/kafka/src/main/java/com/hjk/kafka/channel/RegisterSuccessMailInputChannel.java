package com.hjk.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RegisterSuccessMailInputChannel {

    String REGISTER_SUCCESS_MAIL_CONSUMER = "register-event-in";

    @Input(RegisterSuccessMailInputChannel.REGISTER_SUCCESS_MAIL_CONSUMER)
    SubscribableChannel inputMailChannel();

}