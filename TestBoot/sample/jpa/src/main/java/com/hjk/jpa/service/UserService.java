package com.hjk.jpa.service;

import java.util.List;

import com.hjk.jpa.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    User findByNameAndAge(String name, int age);

    User save(User user);

}


