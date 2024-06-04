package com.onlinebrewery.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinebrewery.order.integration.dto.Product;



@FeignClient(name = "product-client", url = "http://host.docker.internal:8081", primary = false)
public interface ProductsClient {
	@GetMapping("/v1/products/{id}")
	Product getProduct(@PathVariable Integer id);
}
