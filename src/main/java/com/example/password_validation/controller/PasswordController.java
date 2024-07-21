package com.example.password_validation.controller;

import com.example.password_validation.model.Password;
import com.example.password_validation.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PasswordController {


    @Autowired
    private PasswordService passwordService;

    @PostMapping("/validation/password")
    public ResponseEntity<Boolean> validatePassword(@RequestBody Password password) {
        return ResponseEntity.ok(passwordService.passwordValidation(password));
    }
}
