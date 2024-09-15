package com.example.order_service.entity;

import com.example.order_service.enums.OrderStatus;
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
@Entity (name = "orders")
@Table (name = "orders")
public class Order extends BaseEntity<Long> {
    @Column (name = "user_id")
    private String userId;

    @Column (name = "product_id")
    private String productId;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "status", columnDefinition = "VARCHAR(30)")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @Column (name = "final_price")
    private Double finalPrice;

    @PrePersist
    public void prePersist() {
        super.prePersist();
        setStatus(OrderStatus.CREATED);
    }
}
