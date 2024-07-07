package com.micro.productservice.services;


import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;
import com.micro.productservice.entities.ProductDTO;
import com.micro.productservice.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{

    @Autowired
    private final IProductRepository productRepository;


    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
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


    public Product getProduct(long idProduct) {
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


    public Product deleteProduct(long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        product.ifPresent(productRepository::delete);
        return product.orElse(null);
    }


    @Override
    public Product addImageProduct(Long id, File file) {
      Product pr = productRepository.findById(id).orElse(null);

        if (pr != null) {
            pr.setFile(file);
            pr.setFile(file);
            return productRepository.save(pr);
        }
       return null;
    }


    /*
    public List<Product> getAllProductsByCategoryAndSubcategory(MainCategory mainCategory, SubCategory subCategory) {
        return productRepository.findByMainCategoryAndSubCategory(mainCategory, subCategory);
    }
*/

}
