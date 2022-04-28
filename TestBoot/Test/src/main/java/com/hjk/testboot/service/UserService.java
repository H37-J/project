package com.hjk.testboot.service;

import java.util.List;

import com.hjk.testboot.domain.User;

public interface UserService {
    
    List<User> findAll();

    User findByUserId(String userId);

    User login(String userId, String password);

    User save(User user);
}
