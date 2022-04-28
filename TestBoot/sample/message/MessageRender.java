package com.hjk.testboot.sample.message;

public interface MessageRender {
    
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
