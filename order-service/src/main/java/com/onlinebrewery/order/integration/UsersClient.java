package com.onlinebrewery.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinebrewery.order.integration.dto.Product;
import com.onlinebrewery.order.integration.dto.User;



@FeignClient(name = "user-client", url = "http://host.docker.internal:8083", primary = false)
public interface UsersClient {
	@GetMapping("/v1/users/{id}")
	User getUser(@PathVariable Integer id);
}
