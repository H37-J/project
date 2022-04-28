package com.hjk.jpa.service;

import java.util.List;

import com.hjk.jpa.domain.Product;

public interface ProductService {
    List<Product> findAll();
}
