package com.hjk.testboot.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.hjk.testboot.domain.User;
import com.hjk.testboot.repos.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findByUserId(String userId){
        return userRepository.findbyUserId(userId);
    }

    @Override
    public User login(String userId, String password) {
        return userRepository.findByUserIdAndPassword(userId, password);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }
    
}
