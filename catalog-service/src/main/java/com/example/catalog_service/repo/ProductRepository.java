package com.example.catalog_service.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.catalog_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByExternalId(String id);
}
