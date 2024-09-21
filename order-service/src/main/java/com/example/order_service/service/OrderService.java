package com.example.order_service.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.order_service.OrderDetails;
import com.example.order_service.clients.catalogservice.CatalogClient;
import com.example.order_service.clients.domain.Product;
import com.example.order_service.clients.userservice.UserRestClient;
import com.example.order_service.dto.User;
import com.example.order_service.entity.Order;
import com.example.order_service.repo.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRestClient userClient;
    private final CatalogClient catalogClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setUserId(orderDetails.getUserId());
        order.setProductId(orderDetails.getProductId());
        order.setQuantity(orderDetails.getQuantity());
        order.setStatus(orderDetails.getStatus());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDetails getOrderDetailsById(Long id) {
        final Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        String userId = order.getUserId();
        User user = userClient.getUser(userId);
        Product product = catalogClient.getProduct(order.getProductId());
        return OrderDetails.builder().userId(userId).userName(user.getName()).address(user.getAddress()).orderedAt(order.getCreatedAt())
                           .productName(product.getName()).productId(order.getProductId()).orderId(order.getId().toString()).status(order.getStatus())
                           .quantity(order.getQuantity()).finalPrice(order.getFinalPrice()).build();
    }
}
