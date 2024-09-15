package com.example.order_service;

import java.sql.Timestamp;
import com.example.order_service.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private String userId;

    private String userName;

    private String productId;

    private String productName;

    private Timestamp orderedAt;

    private int quantity;

    private String address;

    private OrderStatus status;

    private Double finalPrice;

    private String orderId;
}
