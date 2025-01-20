package com.example.demo.Service;

import com.example.demo.model.Container;
import com.example.demo.repository.ContainerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public Page<Container> getAllContainers(Pageable pageable) {
        return containerRepository.findAll(pageable);
    }

    public Optional<Container> getContainerById(Long id) {
        return containerRepository.findById(id);
    }

    public Container createContainer(Container container) {
        return containerRepository.save(container);
    }

    public Container updateContainer(Long id, Container containerDetails) {
        Container container = containerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Container not found"));
        container.setContainerNumber(containerDetails.getContainerNumber());
        container.setMaxWeight(containerDetails.getMaxWeight());
        container.setMaxVolume(containerDetails.getMaxVolume());
        container.setStatus(containerDetails.getStatus());
        container.setOrder(containerDetails.getOrder());
        return containerRepository.save(container);
    }

    public void deleteContainer(Long id) {
        containerRepository.deleteById(id);
    }
}