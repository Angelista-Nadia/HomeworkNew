package com.example.product.service.impl;

import com.example.product.dto.ProductDto;
import com.example.product.dto.SearchDto;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper mapper;

    @Override
    @Transactional
    public void creatProduct(ProductDto product) {
        // productRepo.save(mapper.toEntity(product));
        var exist = productRepo.findByName(product.getName());
        if (exist != null) {
            exist.setDescription(product.getDescription());
            exist.setQuantity(product.getQuantity());
            exist.setCost(product.getCost());
            exist.setDelivery(product.isDelivery());
            productRepo.update(exist.getId(), product.getCost(), product.getQuantity());
        } else {
            productRepo.save(mapper.toEntity(product));
        }
    }

    @Override
    public List<ProductDto> findAll() {
        return mapper.toDtos(productRepo.findAll());
    }

    @Override
    public List<ProductDto> findBy(SearchDto dto) {
        return mapper.toDtos(productRepo.findByNameLike("%" + dto.getSearch() + "%"));
    }

    @Override
    public List<ProductDto> findBy1(SearchDto dto) {
        return mapper.toDtos(productRepo.findByNameLikeOrQuantityGreaterThanOrCostLessThan
                ("%" + dto.getSearch() + "%", dto.getQuantity(), dto.getCost()));
    }

    @Override
    public List<ProductDto> findByQuantity(SearchDto dto) {
        return mapper.toDtos(productRepo.findByQuantityGreaterThanEqualAndQuantityLessThanEqual
                (dto.getQuantity(), dto.getQuantity2()));
    }

    @Override
    public List<ProductDto> findByCost(SearchDto dto) {
        return mapper.toDtos(productRepo.findByCostGreaterThanEqualAndCostLessThanEqual
                (dto.getCost(), dto.getCost2()));
    }

    @Override
    public List<ProductDto> findByDeliveryTrue() {
        return mapper.toDtos(productRepo.findByDeliveryTrue());
    }

    @Override
    public void deleteAll() {
        productRepo.deleteAll();
    }
}
