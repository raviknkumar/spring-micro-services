package com.example.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;

    private String name;

    private String email;

    private String phone;

    private String password;

    private String address;

    private String about;
}
