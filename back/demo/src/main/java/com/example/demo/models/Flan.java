package com.example.demo.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;
@Data
public class Flan implements Serializable {

    private String id;
    private String name;
    private Set products;
}
