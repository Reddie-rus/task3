package com.example.demo.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class ClientProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema
    private Long id;

    @Schema
    private String name;

    @Schema
    private Double weight;

    @Schema
    private Double volume;

    @ManyToOne
    @JoinColumn(name = "hazard_class_id")
    private HazardClass hazardClass;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public HazardClass getHazardClass() {
        return hazardClass;
    }

    public void setHazardClass(HazardClass hazardClass) {
        this.hazardClass = hazardClass;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}