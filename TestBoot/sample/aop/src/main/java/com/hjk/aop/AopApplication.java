package com.hjk.aop;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.CommandLineRunner;
 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;

 @SpringBootApplication
 public class AopApplication implements CommandLineRunner{
    
     @Autowired
     private AopService aopService;


     @Override
     public void run(String... args) {
         System.out.println(this.aopService.getMessage());
     }

     public static void main(String[] args) {
         SpringApplication.run(AopApplication.class, args);
     }
 }
