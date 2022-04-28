package com.hjk.testboot.sample.message;

import com.hjk.testboot.sample.message.AppConfig;
import com.hjk.testboot.sample.message.MessageRender;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageMain {
    
    public static void main(String[] args){
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRender render = ctx.getBean("messageRender", MessageRender.class);
        render.render();

    }
}
