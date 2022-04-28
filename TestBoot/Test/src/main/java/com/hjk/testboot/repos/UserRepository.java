package com.hjk.testboot.repos;

import com.hjk.testboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  
    User findbyUserId(String userid);
    
    User findByUserIdAndPassword(String userid, String password);
    
    
}
