package com.example.product.repository;

import com.example.product.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

   // @Transactional
    @Modifying
    @Query(value = "update ProductEntity set cost = :cost, quantity = :quantity where id = :id")
    void update(UUID id, Integer cost, Integer quantity);

//    @Transactional
//    @Modifying
//    @Query(value = "update products set cost = :cost where id = :id", nativeQuery = true)
//    void updateCost(UUID id, Integer cost);

    ProductEntity findByName(String name);

    List<ProductEntity> findByNameLike(String name);

    List<ProductEntity> findByNameLikeOrQuantityGreaterThanOrCostLessThan
            (String name, int quantity, int cost);

    List<ProductEntity> findByQuantityGreaterThanEqualAndQuantityLessThanEqual(int quantity, int quantity2);

    List<ProductEntity> findByCostGreaterThanEqualAndCostLessThanEqual(int cost, int cost2);

    List<ProductEntity> findByDeliveryTrue();
}
