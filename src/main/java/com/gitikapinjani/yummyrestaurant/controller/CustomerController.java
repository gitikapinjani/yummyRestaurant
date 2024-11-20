package com.gitikapinjani.yummyrestaurant.controller;

import com.gitikapinjani.yummyrestaurant.dto.CustomerRequest;
import com.gitikapinjani.yummyrestaurant.service.CustomerService;
import com.gitikapinjani.yummyrestaurant.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerRequest request) {
        System.out.println("create controller");
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
}
