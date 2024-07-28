package com.example.product.mapper;

import com.example.product.domain.ProductEntity;
import com.example.product.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T21:54:57+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( dto.getId() );
        productEntity.setName( dto.getName() );
        productEntity.setDescription( dto.getDescription() );
        productEntity.setQuantity( dto.getQuantity() );
        productEntity.setCost( dto.getCost() );
        productEntity.setDelivery( dto.isDelivery() );
        productEntity.setDate( dto.getDate() );

        return productEntity;
    }

    @Override
    public ProductDto toDto(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( entity.getId() );
        productDto.setName( entity.getName() );
        productDto.setDescription( entity.getDescription() );
        productDto.setQuantity( entity.getQuantity() );
        productDto.setCost( entity.getCost() );
        if ( entity.getDelivery() != null ) {
            productDto.setDelivery( entity.getDelivery() );
        }
        productDto.setDate( entity.getDate() );

        return productDto;
    }

    @Override
    public List<ProductDto> toDtos(List<ProductEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entities.size() );
        for ( ProductEntity productEntity : entities ) {
            list.add( toDto( productEntity ) );
        }

        return list;
    }
}
