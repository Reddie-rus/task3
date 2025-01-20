package com.example.demo.Controller;

import com.example.demo.model.Container;
import com.example.demo.Service.ContainerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/containers")
public class ContainerController {

    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping
    public Page<Container> getAllContainers(Pageable pageable) {
        return containerService.getAllContainers(pageable);
    }

    @GetMapping("/{id}")
    public Container getContainerById(@PathVariable Long id) {
        return containerService.getContainerById(id)
                .orElseThrow(() -> new RuntimeException("Container not found"));
    }

    @PostMapping
    public Container createContainer(@RequestBody Container container) {
        return containerService.createContainer(container);
    }

    @PutMapping("/{id}")
    public Container updateContainer(@PathVariable Long id, @RequestBody Container containerDetails) {
        return containerService.updateContainer(id, containerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable Long id) {
        containerService.deleteContainer(id);
    }
}