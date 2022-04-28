package com.hjk.testboot.sample.io.autowired;

import org.springframework.stereotype.Component;

@Component("provider")
public class HellMessageProvider implements MessageProvider{
    
    @Override
    public String getMessage(){
        return "Hell";
    }
}
