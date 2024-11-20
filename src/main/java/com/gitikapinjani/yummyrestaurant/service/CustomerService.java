package com.gitikapinjani.yummyrestaurant.service;

import com.gitikapinjani.yummyrestaurant.dto.CustomerRequest;
import com.gitikapinjani.yummyrestaurant.entity.Customer;
import com.gitikapinjani.yummyrestaurant.mapper.CustomerMapper;
import com.gitikapinjani.yummyrestaurant.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gitikapinjani.yummyrestaurant.helper.EncryptionService;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;

    private final CustomerMapper mapper;

    private final EncryptionService encryptionService;
    public Customer createCustomer(CustomerRequest request) {
        System.out.println("==================== create service");

        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        repo.save(customer);
        return customer;
    }
}