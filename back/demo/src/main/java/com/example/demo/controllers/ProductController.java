package com.example.demo.controllers;


import com.example.demo.models.Product;
import com.example.demo.models.ProductEntity;
import com.example.demo.repositories.ProductEntityRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/product")
public class ProductController {

  private ProductRepository userRepository;
  private ProductEntityRepository productEntityRepository;

  @Autowired
  public ProductController(ProductRepository userRepository, ProductEntityRepository productEntityRepository) {
    this.userRepository = userRepository;
    this.productEntityRepository = productEntityRepository;
  }

  @GetMapping("/add/{id}/{name}")
  public Product add(@PathVariable("id") final String id,
                     @PathVariable("name") final String name) {
    userRepository.save(new Product(Long.parseLong(id), name, 20000D));
    return userRepository.findById(id);
  }

  @GetMapping("/update/{id}/{name}")
  public Product update(@PathVariable("id") final String id,
                        @PathVariable("name") final String name) {
    userRepository.update(new Product(Long.parseLong(id), name, 1000D));
    return userRepository.findById(id);
  }

  @GetMapping("/delete/{id}")
  public Map<String, Product> delete(@PathVariable("id") final String id) {
    userRepository.delete(id);
    return all();
  }

  @GetMapping("/all")
  public Map<String, Product> all() {
    return userRepository.findAll();
  }

  @PostMapping("")
  public ProductEntity addProductEntity(@RequestBody Product product) {
    //this.userRepository.save(product);
    return this.productEntityRepository.save(product.toEntity());
  }

  @GetMapping("")
  public List<ProductEntity> getAll() {
    List<ProductEntity> list = this.productEntityRepository.findAll();
    return list;
  }

  @GetMapping("/defected")
  public List<ProductEntity> getDefected() {
    List<ProductEntity> list = this.productEntityRepository.findAllByIsDefective(true);
    return list;
  }

  @PutMapping("")
  public Long editProductEntity(@RequestBody Product product) {

    return this.productEntityRepository.save(product.toEntity()).getId();
  }

  @GetMapping("lastAdded")
  public Collection<Product> getLastAdded() {
    Map<String, Product> productMap = this.userRepository.findAll();
    return productMap.values();
  }
  @DeleteMapping("/{id}/{matricule}")
  public void deleteProduct(@PathVariable("id") Long id,@PathVariable("matricule") String matricule){
    this.productEntityRepository.deleteById(id);
    this.userRepository.findById(matricule);
  }
}
