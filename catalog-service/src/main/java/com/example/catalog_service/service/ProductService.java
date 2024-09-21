package com.example.catalog_service.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.catalog_service.entity.Product;
import com.example.catalog_service.exception.ResourceNotFoundException;
import com.example.catalog_service.repo.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor (onConstructor_ = @Autowired)
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        productRepository.delete(product);
    }

    public Product getProductByExternalId(String id) {
        return productRepository.findProductByExternalId(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    }
}
