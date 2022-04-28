package com.hjk.testboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@EnableScheduling
@SpringBootApplication
public class TestBootApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("test");
    }
}
