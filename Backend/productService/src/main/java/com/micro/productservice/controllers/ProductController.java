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
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private IProductService productService;
    private IFileService fileService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping("getProductById/{id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("id") Integer productId
    ) {
        return ResponseEntity.ok(productService.findById(productId));
    }


    @PostMapping("/addProduct")
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(productService.createProduct(request));
    }




    @PutMapping("/addImage/{id}")
    public ResponseEntity<Product> addImage(@PathVariable("id") int id, @RequestParam("file") MultipartFile file){
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
