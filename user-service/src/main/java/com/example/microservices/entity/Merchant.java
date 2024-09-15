package com.example.microservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table (name = "merchants")
@Entity (name = "merchants")
public class Merchant extends BaseEntity<Long> {

    @Column(name = "external_id")
    private String externalId;

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;
}