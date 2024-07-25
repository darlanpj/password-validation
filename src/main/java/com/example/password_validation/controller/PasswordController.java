package com.example.password_validation.controller;

import com.example.password_validation.model.Password;
import com.example.password_validation.service.PasswordService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PasswordController {

    private static final Log LOG = LogFactory.getLog(PasswordController.class);

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/validation/password")
    public ResponseEntity<Boolean> validatePassword(@RequestBody Password password) {
        LOG.info("Request: " + password.toString());
        return ResponseEntity.ok(passwordService.passwordValidation(password));
    }
}
