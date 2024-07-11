package com.micro.productservice.services;


import com.micro.productservice.controllers.ProductPurchaseRequest;
import com.micro.productservice.controllers.ProductPurchaseResponse;
import com.micro.productservice.controllers.ProductRequest;
import com.micro.productservice.controllers.ProductResponse;
import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;
import com.micro.productservice.entities.ProductDTO;
import com.micro.productservice.repository.IProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{


    private final IProductRepository productRepository;
    private final ProductMapper productMapper;


@Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }



    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory());

        if (product.getFile() != null) {
            dto.setFileName(product.getFile().getFileName());
            dto.setFileData(Base64.getEncoder().encodeToString(product.getFile().getData()));
        }

        return dto;
    }


    public Product getProduct(int idProduct) {
        return productRepository.findById(idProduct).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        return null;
    }


    public Product deleteProduct(int idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        product.ifPresent(productRepository::delete);
        return product.orElse(null);
    }


    @Override
    public Product addImageProduct(int id, File file) {
      Product pr = productRepository.findById(id).orElse(null);

        if (pr != null) {
            pr.setFile(file);
            pr.setFile(file);
            return productRepository.save(pr);
        }
       return null;
    }

    @Override
    @Transactional
    public List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new NoSuchElementException("One or more products not found");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getQt() < productRequest.quantity()) {
                throw new IllegalArgumentException("Insufficient quantity for product ID: " + product.getId());
            }
            var newAvailableQuantity = product.getQt() - productRequest.quantity();
            product.setQt(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toproductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::fromProduct)
                .orElse(null);
    }

    @Override
    public Integer createProduct(
            ProductRequest request
    ) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

}
