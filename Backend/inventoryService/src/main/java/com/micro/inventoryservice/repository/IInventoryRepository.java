package com.micro.inventoryservice.repository;


import com.micro.inventoryservice.entities.Inventory;
import com.micro.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProduct(Product product);

    Optional<Inventory> findByProductId(Long productId);


}