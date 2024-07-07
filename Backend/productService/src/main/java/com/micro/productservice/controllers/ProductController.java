package com.micro.productservice.controllers;


import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;

import com.micro.productservice.entities.ProductDTO;
import com.micro.productservice.services.IFileService;
import com.micro.productservice.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")

public class ProductController {

    private ProductService productService;
    private IFileService fileService;

    @PutMapping("/addImage/{id}")
    public ResponseEntity<Product> addImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
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


    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping("/addProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        if (productService.getProduct(id) == null) {
            return ResponseEntity.notFound().build();
        }
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Product deletedProduct = productService.deleteProduct(id);
        if (deletedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
