package com.micro.productservice.controllers;


import com.micro.productservice.entities.*;

import com.micro.productservice.services.IFileService;
import com.micro.productservice.services.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")

public class ProductController {

    private IProductService productService;
    private IFileService fileService;

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(productService.purchaseProducts(request));
    }


    @PutMapping("/addImage/{id}")
    public ResponseEntity<Product> addImage(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
        try {
            File savedFile = fileService.saveFile(file);
            if (savedFile != null) {
                Product updatedProduct = productService.addImageProduct(id, savedFile);
                return ResponseEntity.ok(updatedProduct);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
