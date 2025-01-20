package com.example.demo.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Entity
public class HazardClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema
    private Long id;

    @Schema
    private String code;

    @Schema
    private String description;

    @OneToMany(mappedBy = "hazardClass")
    private List<ClientProduct> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClientProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ClientProduct> products) {
        this.products = products;
    }
}