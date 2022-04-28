package com.hjk.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RegisterSuccessOutputChannel {
    
    String REGISTER_SUCCESS_OUTPUT_NAME="register-event-out";
    
    @Output(RegisterSuccessOutputChannel.REGISTER_SUCCESS_OUTPUT_NAME)
    MessageChannel outputChannel();
}
