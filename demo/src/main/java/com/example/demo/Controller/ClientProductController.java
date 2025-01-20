package com.example.demo.Controller;

import com.example.demo.model.ClientProduct;
import com.example.demo.Service.ClientProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client-products")
public class ClientProductController {

    private final ClientProductService clientProductService;

    public ClientProductController(ClientProductService clientProductService) {
        this.clientProductService = clientProductService;
    }

    @GetMapping
    public Page<ClientProduct> getAllClientProducts(Pageable pageable) {
        return clientProductService.getAllClientProducts(pageable);
    }

    @GetMapping("/{id}")
    public ClientProduct getClientProductById(@PathVariable Long id) {
        return clientProductService.getClientProductById(id)
                .orElseThrow(() -> new RuntimeException("ClientProduct not found"));
    }

    @PostMapping
    public ClientProduct createClientProduct(@RequestBody ClientProduct clientProduct) {
        return clientProductService.createClientProduct(clientProduct);
    }

    @PutMapping("/{id}")
    public ClientProduct updateClientProduct(@PathVariable Long id, @RequestBody ClientProduct clientProductDetails) {
        return clientProductService.updateClientProduct(id, clientProductDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteClientProduct(@PathVariable Long id) {
        clientProductService.deleteClientProduct(id);
    }
}