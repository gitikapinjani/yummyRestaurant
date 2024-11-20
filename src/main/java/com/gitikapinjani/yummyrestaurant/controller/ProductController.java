package com.gitikapinjani.yummyrestaurant.controller;
import com.gitikapinjani.yummyrestaurant.dto.ProductRequest;
import com.gitikapinjani.yummyrestaurant.entity.Product;
import com.gitikapinjani.yummyrestaurant.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    // final : it will create only one object in whole project container, when we run the project
    private final ProductService productService;

    @PostMapping ("/add")// for post request
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductRequest request) {
        System.out.println("create controller");
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @PostMapping ("/deleteById/{id}")// for post request
    public ResponseEntity<String> deleteProductById(@PathVariable @Valid Long id) {
        System.out.println("delete controller");
        productService.deleteProductById(id);
        return ResponseEntity.ok("successfully deleted");
    }

    @GetMapping({"/get", "/get/{id}"})
    public ResponseEntity<?> getProducts(@PathVariable(required = false) Long id) {
        if (id != null) {
            // If an ID is provided, fetch and return the specific product
            Product product = productService.getProductById(id);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            // If no ID is provided, fetch and return all products
            List<Product> allProducts = productService.getAllProducts();
            return ResponseEntity.ok(allProducts);
        }
    }

    @GetMapping({"/get_top_2"})
    public List<Product> getTop2Products(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productService.getTop2ProductsInPriceRange(minPrice, maxPrice);
    }
}