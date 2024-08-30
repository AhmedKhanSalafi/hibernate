package com.Pessimistic.Pessimistic.locking.controller;


import com.Pessimistic.Pessimistic.locking.entity.Product;
import com.Pessimistic.Pessimistic.locking.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint for saving a new product
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Endpoint for pessimistic locking
    @PutMapping("/pessimistic/{id}")
    public String updateProductPricePessimistic(@PathVariable Long id, @RequestParam Double newPrice) {
        productService.updateProductPricePessimistic(id, newPrice);
        return "Product price updated with pessimistic lock.";
    }

    // Endpoint for optimistic locking
    @PutMapping("/optimistic/{id}")
    public String updateProductPriceOptimistic(@PathVariable Long id, @RequestParam Double newPrice) {
        productService.updateProductPriceOptimistic(id, newPrice);
        return "Product price updated with optimistic lock.";
    }
}


