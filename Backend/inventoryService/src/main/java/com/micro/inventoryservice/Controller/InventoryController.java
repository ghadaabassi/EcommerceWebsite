package com.micro.inventoryservice.Controller;

import com.micro.inventoryservice.entities.Inventory;
import com.micro.inventoryservice.service.IInventoryService;
import com.micro.productservice.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventory")
//@CrossOrigin(origins = "*")
@AllArgsConstructor
public class InventoryController {
 IInventoryService inventoryService;

 @DeleteMapping("/Delete")
    public void consumeOrderDeletedEvent(Long orderId) {
        System.out.println("Consumed Order Deleted: " + orderId);
        inventoryService.deleteOrder(orderId);
    }


@PostMapping("/createInventory")
public Inventory addInventory(@RequestBody Inventory inventory){
     return inventoryService.addInventory(inventory);
}

@GetMapping("/getAllInv")
public List<Inventory> findAll(){
     return inventoryService.getAllInventories();
}

@GetMapping("/getInvById/{id}")
public Inventory findById(@PathVariable Long id){
     return inventoryService.getInventoryById(id);
}

@PutMapping("/addProductInventory/{id}")
    public Inventory addProduct(@RequestBody Product product , @PathVariable long id){
     return inventoryService.addProductInventory(id,product);
}

    @DeleteMapping("/deleteInventoryByProduct/{productId}")
    public ResponseEntity<Void> deleteInventoryByProduct(@PathVariable("productId") Long productId) {
        boolean deleted = inventoryService.deleteInventoryByProductId(productId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
