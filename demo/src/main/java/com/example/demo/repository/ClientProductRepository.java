package com.example.demo.repository;

import com.example.demo.model.ClientProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProductRepository extends JpaRepository<ClientProduct, Long> {
}