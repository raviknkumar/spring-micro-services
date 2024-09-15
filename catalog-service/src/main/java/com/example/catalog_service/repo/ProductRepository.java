package com.example.catalog_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.catalog_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
