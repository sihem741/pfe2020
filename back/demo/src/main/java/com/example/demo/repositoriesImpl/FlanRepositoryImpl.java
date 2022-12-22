package com.example.demo.repositoriesImpl;

import com.example.demo.models.Flan;
import com.example.demo.models.Flan;
import com.example.demo.repositories.FlanEntityRepository;
import com.example.demo.repositories.FlanRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public class FlanRepositoryImpl implements FlanRepository , FlanEntityRepository {
    private RedisTemplate<String, Flan> redisTemplate;

    private HashOperations hashOperations;


    public FlanRepositoryImpl(RedisTemplate<String, Flan> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Flan flan) {
        hashOperations.put("FLAN", flan.getId(), flan);
    }

    @Override
    public Map<String, Flan> findAll() {
        return hashOperations.entries("FLAN");
    }

    @Override
    public Flan findById(String id) {
        return (Flan)hashOperations.get("FLAN", id);
    }

    @Override
    public void update(Flan flan) {
        save(flan);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete("FLAN", id);
    }
}
