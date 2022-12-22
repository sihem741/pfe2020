package com.example.demo.repositories;

import com.example.demo.models.Flan;

import java.util.Map;

public interface FlanRepository {
    void save(Flan user);
    Map<String, Flan> findAll();
    Flan findById(String id);
    void update(Flan user);
    void delete(String id);
}
