package com.example.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private String description;
    private int quantity;
    private int cost;

    private Boolean delivery;

    @CreationTimestamp
    private LocalDateTime date;
}
