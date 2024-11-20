package com.gitikapinjani.yummyrestaurant.repo;
import java.util.Optional;

import com.gitikapinjani.yummyrestaurant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
