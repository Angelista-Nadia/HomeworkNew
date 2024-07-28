package com.example.product.domain;

import java.util.UUID;

public interface ProductProjection {

    UUID getId();

    String getName();

    String getDescription();

    Integer getQuantity();

    Integer getCost();

    Double getDelivery();
}
