package com.onlinebrewery.product.contoller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebrewery.product.domain.Product;
import com.onlinebrewery.product.service.ProductsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> getProducts() {
        log.info("Products request");
        return ResponseEntity.ok(productsService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        log.info("Product request {}", id);
        return ResponseEntity.of(productsService.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) throws URISyntaxException {
        log.info("Create product {}", product);
        var created = productsService.createProduct(product);
        return ResponseEntity.created(new URI("v1/products/" + created.getId())).build();
    }
}
