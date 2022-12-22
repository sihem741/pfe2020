package com.example.demo.repositories;

import com.example.demo.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findAllByIsDefective(boolean defective);
}
