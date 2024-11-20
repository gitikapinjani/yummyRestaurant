package com.gitikapinjani.yummyrestaurant.service;

import com.gitikapinjani.yummyrestaurant.dto.ProductRequest;
import com.gitikapinjani.yummyrestaurant.entity.Product;
import com.gitikapinjani.yummyrestaurant.helper.EncryptionService;
import com.gitikapinjani.yummyrestaurant.mapper.ProductMapper;
import com.gitikapinjani.yummyrestaurant.repo.ProductRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductRepo repo;

    private final ProductMapper mapper;
    private final EncryptionService encryptionService;

    public Product addProduct(ProductRequest request) {
        System.out.println("create service");

        // This will convert our dto to entity using Mapper
        Product product = mapper.toEntity(request);
        repo.save(product);
        return product;
    }

    public Product getProductById(Long id) {
        System.out.println("getProductById service");
        // return repo.findById(id).orElse(null); // Returns the product or null if not found
        System.out.println("JPA REPO getProductById service");
        return repo.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        System.out.println("getAllProducts service");
        // return repo.findAll(); // Returns all products
        return repo.findAll();
    }

    public List<Product> getTop2ProductsInPriceRange(double minPrice, double maxPrice) {
        Pageable pageable = PageRequest.of(0, 2);
        return repo.findTop2ProductsInPriceRange(minPrice, maxPrice, pageable);
    }

    public void deleteProductById(Long id) {
        Product product = getProductById(id);
        repo.delete(product);

    }
}