package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.dto.SearchDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    void creatProduct(ProductDto product);

    List<ProductDto> findAll();

    List<ProductDto> findBy(SearchDto dto);

    List<ProductDto> findBy1(SearchDto dto);

    List<ProductDto> findByDeliveryTrue();

    List<ProductDto> findByQuantity(SearchDto dto);

    List<ProductDto> findByCost(SearchDto dto);

    void deleteAll();
}
