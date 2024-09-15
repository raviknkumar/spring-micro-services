package com.example.catalog_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.catalog_service.entity.Product;
import com.example.catalog_service.exception.ResourceNotFoundException;
import com.example.catalog_service.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/products")
@RequiredArgsConstructor (onConstructor_ = @Autowired)
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id") Long id) {
        Product product = productService.getProductById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable (value = "id") Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable (value = "id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
