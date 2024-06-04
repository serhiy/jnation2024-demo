package com.onlinebrewery.product.repo;

import org.springframework.data.repository.CrudRepository;

import com.onlinebrewery.product.domain.Product;



public interface ProductRepository extends CrudRepository<Product, Integer> {

}
