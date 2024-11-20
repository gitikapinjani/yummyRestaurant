package com.gitikapinjani.yummyrestaurant.repo;

import org.springframework.data.jpa.repository.Query;
import com.gitikapinjani.yummyrestaurant.entity.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC")
    List<Product> findTop2ProductsInPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice, Pageable pageable);
}
