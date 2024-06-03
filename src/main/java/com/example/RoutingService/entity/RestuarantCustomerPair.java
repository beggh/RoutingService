package com.example.RoutingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestuarantCustomerPair {
    private Location restaurant;
    private Location customer;
}
