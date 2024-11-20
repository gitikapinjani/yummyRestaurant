package com.gitikapinjani.yummyrestaurant.mapper;

import com.gitikapinjani.yummyrestaurant.dto.ProductRequest;
import com.gitikapinjani.yummyrestaurant.entity.Product;
import org.springframework.stereotype.Service;
@Service
public class ProductMapper {
    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .productName(request.productName())
                .price(request.price())
                .build();
    }
}
