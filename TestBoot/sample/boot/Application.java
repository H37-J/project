package com.hjk.testboot.sample.boot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;

public class Application {
    
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) throws Exception {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(BootConfig.class);
        assert(ctx != null);
        logger.info("빈을 검색하는 중:");

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(logger::info);

        Hell hell = ctx.getBean(Hell.class);
        hell.hi();

        System.in.read();
        ctx.close();
    }
}
