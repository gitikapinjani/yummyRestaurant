package com.gitikapinjani.yummyrestaurant.mapper;

import com.gitikapinjani.yummyrestaurant.dto.CustomerRequest;
import com.gitikapinjani.yummyrestaurant.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())

                .email(request.email())
                .password(request.password())
                .build();
    }
}
