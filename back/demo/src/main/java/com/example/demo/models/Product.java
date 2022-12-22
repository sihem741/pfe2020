package com.example.demo.models;

import lombok.Data;

import java.io.Serializable;
@Data
public class Product implements Serializable {

    private Long id;
    private String name;
    private String matricule;
    private String defectiveCause;


    private Double price;
    private Boolean isDefective;
    private String user;
    private String flan;

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductEntity toEntity(){

        ProductEntity productEntity=new ProductEntity();
        productEntity.setId(this.id);
        productEntity.setMatricule(this.matricule);
        productEntity.setName(this.name);
        FlanEntity flanEntity=new FlanEntity();
        flanEntity.setMatricule(this.flan);
        productEntity.setFlan(flanEntity);
        productEntity.setUser(this.user);
        productEntity.setIsDefective(this.isDefective);
        productEntity.setDefectiveCause(defectiveCause);
        return productEntity;
    }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  public String getDefectiveCause() {
    return defectiveCause;
  }

  public void setDefectiveCause(String defectiveCause) {
    this.defectiveCause = defectiveCause;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getDefective() {
    return isDefective;
  }

  public void setDefective(Boolean defective) {
    isDefective = defective;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getFlan() {
    return flan;
  }

  public void setFlan(String flan) {
    this.flan = flan;
  }
}
