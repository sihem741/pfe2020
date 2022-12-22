package com.example.demo.repositories;

import com.example.demo.models.Product;

import java.util.Map;

public interface ProductRepository {

    void save(Product user);
    Map<String, Product> findAll();
    Product findById(String id);
    void update(Product user);
    void delete(String id);
}
