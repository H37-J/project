package com.hjk.testboot.sample.message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public MessageProvider messageProvider(){
        return new MessageProviderImpl("기본 메시지");
    }

    @Bean
    public MessageRender messageRender(){
        MessageRender render=new MessageRenderImpl();
        render.setMessageProvider(messageProvider());
        return render;
    }

}
