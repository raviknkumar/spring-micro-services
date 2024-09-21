package com.example.order_service.clients.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String externalId;

    private String name;

    private String description;

    private String merchantId;

    private Double price;

    private ProductStatus status;
}