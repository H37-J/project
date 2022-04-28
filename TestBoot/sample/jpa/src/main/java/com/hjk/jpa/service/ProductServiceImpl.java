package com.hjk.jpa.service;

import java.util.List;

import com.hjk.jpa.domain.Product;
import com.hjk.jpa.repos.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
