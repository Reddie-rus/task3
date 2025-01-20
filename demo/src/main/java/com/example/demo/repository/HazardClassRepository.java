package com.example.demo.repository;

import com.example.demo.model.HazardClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HazardClassRepository extends JpaRepository<HazardClass, Long> {
}