package com.hjk.aop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AopService {
    
    @Value("${name:World}")
    private String name;

    public String getMessage(){
        return "Hello" + this.name;
    }
}
