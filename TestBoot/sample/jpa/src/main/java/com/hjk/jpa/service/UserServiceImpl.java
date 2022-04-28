package com.hjk.jpa.service;

import java.util.List;

import com.hjk.jpa.domain.User;
import com.hjk.jpa.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }   

    @Override
    public User findByNameAndAge(String name, int age) {
        Assert.notNull(name, "Name must not be null");
        Assert.notNull(age, "Age must not be null");
        return userRepository.findByNameAndAge(name, age);
    }   

    @Override
    public User save(User user){
        return userRepository.save(user);
    }
}
