package com.example.order_service.clients.userservice;

import com.example.order_service.dto.User;

public interface UserClient {

    User getUser(String userId);
}
