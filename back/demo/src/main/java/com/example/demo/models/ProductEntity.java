package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricule;
    private String defectiveCause;

    private String name;
    private Double price;
    private Boolean isDefective;
    private String user;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private FlanEntity flan;

    public ProductEntity() {
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsDefective() {
        return isDefective;
    }

    public void setIsDefective(Boolean defective) {
        isDefective = defective;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public FlanEntity getFlan() {
        return flan;
    }

    public void setFlan(FlanEntity flan) {
        this.flan = flan;
    }

    public String getDefectiveCause() {
        return defectiveCause;
    }

    public void setDefectiveCause(String defectiveCause) {
        this.defectiveCause = defectiveCause;
    }

    public Boolean getDefective() {
        return isDefective;
    }

    public void setDefective(Boolean defective) {
        isDefective = defective;
    }
}
