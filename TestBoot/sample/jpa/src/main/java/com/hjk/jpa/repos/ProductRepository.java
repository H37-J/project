package com.hjk.jpa.repos;

import com.hjk.jpa.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
