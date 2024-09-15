package com.example.catalog_service.entity;

import java.util.UUID;
import com.example.catalog_service.enums.ProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode (callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
@Table(name = "products")
public class Product extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "description")
    private String description;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "price")
    private Double price;

    @Column(name = "status", columnDefinition = "VARCHAR(30)")
    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

    @PrePersist
    public void prePersist() {
        setExternalId(UUID.randomUUID().toString());
        this.status = ProductStatus.CREATED;
        super.prePersist();
    }
}
