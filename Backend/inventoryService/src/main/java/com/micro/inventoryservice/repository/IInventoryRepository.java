package com.micro.inventoryservice.repository;


import com.micro.inventoryservice.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Long> {
}
