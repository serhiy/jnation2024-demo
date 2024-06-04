package com.onlinebrewery.order.domain;

import lombok.*;

import java.util.Map;

@Value
@Builder
public class Order {
    String id;
    Integer customerId;
    String customerAddress;
    Map<Integer, Integer> products;
    Double totalCost;
}
