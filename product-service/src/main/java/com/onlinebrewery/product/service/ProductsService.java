package com.onlinebrewery.product.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onlinebrewery.product.domain.Product;
import com.onlinebrewery.product.repo.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductRepository repository;

    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProduct(Integer id) {
        return repository.findById(id);
    }

    public Product createProduct(Product product) {
        if (repository.findById(product.getId()).isPresent()) {
            throw new IllegalArgumentException("Cannot insert product, product with this is already exists.");
        }
        return repository.save(product);
    }
}
