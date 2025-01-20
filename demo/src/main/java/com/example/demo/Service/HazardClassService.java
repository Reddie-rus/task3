package com.example.demo.Service;

import com.example.demo.model.HazardClass;
import com.example.demo.repository.HazardClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HazardClassService {

    private final HazardClassRepository hazardClassRepository;

    public HazardClassService(HazardClassRepository hazardClassRepository) {
        this.hazardClassRepository = hazardClassRepository;
    }

    public Page<HazardClass> getAllHazardClasses(Pageable pageable) {
        return hazardClassRepository.findAll(pageable);
    }

    public Optional<HazardClass> getHazardClassById(Long id) {
        return hazardClassRepository.findById(id);
    }

    public HazardClass createHazardClass(HazardClass hazardClass) {
        return hazardClassRepository.save(hazardClass);
    }

    public HazardClass updateHazardClass(Long id, HazardClass hazardClassDetails) {
        HazardClass hazardClass = hazardClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HazardClass not found"));
        hazardClass.setCode(hazardClassDetails.getCode());
        hazardClass.setDescription(hazardClassDetails.getDescription());
        return hazardClassRepository.save(hazardClass);
    }

    public void deleteHazardClass(Long id) {
        hazardClassRepository.deleteById(id);
    }
}