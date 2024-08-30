package com.Pessimistic.Pessimistic.locking.service;

import com.Pessimistic.Pessimistic.locking.entity.Product;
import com.Pessimistic.Pessimistic.locking.exception.EntityNotFoundException;
import com.Pessimistic.Pessimistic.locking.repo.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void updateProductPricePessimistic(Long id, Double newPrice) {
        Optional<Product> product = productRepository.findByIdForUpdate(id);
        product.ifPresent(p -> {
            p.setPrice(newPrice);
            productRepository.save(p);
        });
    }

    @Transactional
    public void updateProductPriceOptimistic(Long id, Double newPrice) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(p -> {
            p.setPrice(newPrice);
            productRepository.save(p);
        });
    }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}