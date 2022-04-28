package com.hjk.testboot.sample.io.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class MessageRender {
    MessageProvider messageProvider;

    @Autowired
    public void setMessageProvider(MessageProvider messageProvider){
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider(){
        return this.messageProvider;
    }

    public void render(){
        System.out.println(messageProvider.getMessage());
    }
}
