package com.gitikapinjani.yummyrestaurant.service;

import java.util.Optional;
import com.gitikapinjani.yummyrestaurant.dto.LoginRequest;
import com.gitikapinjani.yummyrestaurant.entity.Customer;
import com.gitikapinjani.yummyrestaurant.mapper.LoginMapper;
import com.gitikapinjani.yummyrestaurant.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gitikapinjani.yummyrestaurant.helper.EncryptionService;
import com.gitikapinjani.yummyrestaurant.helper.JWTHelper;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepo repo;
    private final LoginMapper mapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String loginUser(LoginRequest request) {
        Customer customer = mapper.toEntity(request);
        Optional<Customer> existingCustomer = repo.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {
            if(!encryptionService.validates(request.password(), existingCustomer.get().getPassword())) {
                return "Wrong Password or Email";
            }
            else {
                return jwtHelper.generateToken(request.email());
            }
        } else {
            return "User not found";
        }
    }
}
