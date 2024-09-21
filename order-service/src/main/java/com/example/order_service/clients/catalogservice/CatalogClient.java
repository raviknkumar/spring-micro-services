package com.example.order_service.clients.catalogservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.order_service.clients.domain.Product;

@FeignClient ("${catalog-service.name}")
public interface CatalogClient {

    @GetMapping("/catalog-service/products/external-id/{productId}")
    Product getProduct(@PathVariable("productId") String productId);
}
