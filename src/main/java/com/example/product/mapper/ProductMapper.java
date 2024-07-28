package com.example.product.mapper;

import com.example.product.domain.ProductEntity;
import com.example.product.dto.ProductDto;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDto dto);

    ProductDto toDto(ProductEntity entity);

    List<ProductDto> toDtos(List<ProductEntity> entities);
}
