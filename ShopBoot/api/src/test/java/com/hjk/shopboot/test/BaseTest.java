package com.hjk.shopboot.test;

import java.time.LocalDateTime;
import java.util.Date;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hjk.dto.UserRequestDto;
import com.hjk.model.Product;
import com.hjk.model.User;
import com.hjk.shopboot.service.UserService;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles
@Transactional
@SpringBootTest
@Slf4j
public class BaseTest {

    @Autowired protected MockMvc mvc;
    @Autowired RedisTemplate redisTemplate;
    @Autowired protected WebApplicationContext webApplicationContext;

    @Test
    @DisplayName("Redis 테스트")
    public void baseTest1(){
        ValueOperations<String,User> valueOperation=redisTemplate.opsForValue();
        UserRequestDto.LoginRequestDto user= UserRequestDto.LoginRequestDto.buildDto("test001","star8903");
        valueOperation.set("users",user.toEntity());
        User u=valueOperation.get("users");
        log.info("redis test:",u.getAccountId());
        System.out.println(u.getAccountId());

    }

}
