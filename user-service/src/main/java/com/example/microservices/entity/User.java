package com.example.microservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity (name = "users")
public class User extends BaseEntity<Long> {

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;

    @Column (name = "password")
    private String password;

    @Column (name = "address")
    private String address;

    @Column (name = "about")
    private String about;
}
