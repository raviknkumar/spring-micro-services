package com.example.order_service.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity<T> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    protected T id;

    @Column (name = "created_at")
    protected Timestamp createdAt;

    @Column (name = "updated_at")
    protected Timestamp updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}

