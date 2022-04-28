package com.hjk.jpa;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hjk.jpa.domain.User;
import com.hjk.jpa.service.UserService;

@Slf4j
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;
    
    @Test
    public void testSave(){
        List<User> users = userService.findAll();

        for(User user : users){
            log.info((user.toString()));
        }
    }
}
