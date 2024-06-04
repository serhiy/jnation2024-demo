package com.onlinebrewery.order.service;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.onlinebrewery.order.domain.Order;
import com.onlinebrewery.order.integration.ProductsClient;
import com.onlinebrewery.order.integration.UsersClient;
import com.onlinebrewery.order.integration.dto.Product;

import lombok.RequiredArgsConstructor;



@Component
@RequiredArgsConstructor
public class OrdersService {

    private final ProductsClient productsClient;
    private final UsersClient usersClient;

    public Order processOrder(Map<Integer, Integer> products, Integer customerId) {
        var productPrices = products.keySet().stream()
                                    .map(productsClient::getProduct)
                                    .collect(Collectors.toMap(Product::getId, Product::getPrice));

        var totalCost = products.keySet().stream()
                                .mapToDouble(id -> costForProduct(products.get(id), productPrices.get(id)))
                                .sum();

        var customer = usersClient.getUser(customerId);

        return Order.builder()
                    .id(UUID.randomUUID().toString())
                    .customerId(customerId)
                    .customerAddress(customer.getAddress())
                    .products(products)
                    .totalCost(totalCost)
                    .build();
    }

    private Double costForProduct(Integer quantity, Double price) {
        return quantity * price;
    }
}
