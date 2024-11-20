package com.gitikapinjani.yummyrestaurant.controller;

import com.gitikapinjani.yummyrestaurant.dto.LoginRequest;
import com.gitikapinjani.yummyrestaurant.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody @Valid LoginRequest request) {
        System.out.println("login");
        return ResponseEntity.ok(loginService.loginUser(request));
    }
}
