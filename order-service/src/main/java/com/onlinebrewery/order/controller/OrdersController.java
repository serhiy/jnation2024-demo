package com.onlinebrewery.order.controller;

import com.onlinebrewery.order.domain.Order;
import com.onlinebrewery.order.dto.OrderRequest;
import com.onlinebrewery.order.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody OrderRequest order) {
        return ResponseEntity.ok(ordersService.processOrder(order.getProducts(), order.getCustomerId()));
    }
}
