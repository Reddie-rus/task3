package com.example.demo.Controller;

import com.example.demo.model.HazardClass;
import com.example.demo.Service.HazardClassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hazard-classes")
public class HazardClassController {

    private final HazardClassService hazardClassService;

    public HazardClassController(HazardClassService hazardClassService) {
        this.hazardClassService = hazardClassService;
    }

    @GetMapping
    public Page<HazardClass> getAllHazardClasses(Pageable pageable) {
        return hazardClassService.getAllHazardClasses(pageable);
    }

    @GetMapping("/{id}")
    public HazardClass getHazardClassById(@PathVariable Long id) {
        return hazardClassService.getHazardClassById(id)
                .orElseThrow(() -> new RuntimeException("HazardClass not found"));
    }

    @PostMapping
    public HazardClass createHazardClass(@RequestBody HazardClass hazardClass) {
        return hazardClassService.createHazardClass(hazardClass);
    }

    @PutMapping("/{id}")
    public HazardClass updateHazardClass(@PathVariable Long id, @RequestBody HazardClass hazardClassDetails) {
        return hazardClassService.updateHazardClass(id, hazardClassDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHazardClass(@PathVariable Long id) {
        hazardClassService.deleteHazardClass(id);
    }
}