package com.gitikapinjani.yummyrestaurant.mapper;

import com.gitikapinjani.yummyrestaurant.dto.LoginRequest;
import com.gitikapinjani.yummyrestaurant.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class LoginMapper {
    public Customer toEntity(LoginRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}
