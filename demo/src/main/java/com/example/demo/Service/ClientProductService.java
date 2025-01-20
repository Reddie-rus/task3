package com.example.demo.Service;

import com.example.demo.model.ClientProduct;
import com.example.demo.repository.ClientProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientProductService {

    private final ClientProductRepository clientProductRepository;

    public ClientProductService(ClientProductRepository clientProductRepository) {
        this.clientProductRepository = clientProductRepository;
    }

    public Page<ClientProduct> getAllClientProducts(Pageable pageable) {
        return clientProductRepository.findAll(pageable);
    }

    public Optional<ClientProduct> getClientProductById(Long id) {
        return clientProductRepository.findById(id);
    }

    public ClientProduct createClientProduct(ClientProduct clientProduct) {
        return clientProductRepository.save(clientProduct);
    }

    public ClientProduct updateClientProduct(Long id, ClientProduct clientProductDetails) {
        ClientProduct clientProduct = clientProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClientProduct not found"));
        clientProduct.setName(clientProductDetails.getName());
        clientProduct.setWeight(clientProductDetails.getWeight());
        clientProduct.setVolume(clientProductDetails.getVolume());
        clientProduct.setHazardClass(clientProductDetails.getHazardClass());
        clientProduct.setClient(clientProductDetails.getClient());
        clientProduct.setOrder(clientProductDetails.getOrder());
        return clientProductRepository.save(clientProduct);
    }

    public void deleteClientProduct(Long id) {
        clientProductRepository.deleteById(id);
    }
}