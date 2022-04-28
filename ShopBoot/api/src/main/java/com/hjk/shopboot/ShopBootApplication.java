package com.hjk.shopboot;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy //AOP활성화
@EnableBatchProcessing //배치 활성화
@EnableScheduling //스케쥴러 활성화
@EntityScan("com.hjk.model")
@ComponentScans(value = { @ComponentScan("com.hjk.kafka.publisher"),
        @ComponentScan("com.hjk.kafka.channel"),
        @ComponentScan("com.hjk.redis.config")
})
public class ShopBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBootApplication.class, args);
    }

}
