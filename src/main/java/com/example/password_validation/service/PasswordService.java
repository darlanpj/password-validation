package com.example.password_validation.service;

import com.example.password_validation.model.Password;
import com.example.password_validation.service.impl.PasswordRules;
import org.springframework.stereotype.Service;

@Service
public class PasswordService implements PasswordRules {


    public boolean passwordValidation(Password password) {
        try {

        } catch (Exception e) {
            return false;
        }
        return false;
    }


    @Override
    public boolean validatePasswordLength(String password) {
        return false;
    }

    @Override
    public boolean validatePasswordAtLeastOneDigit(String password) {
        return false;
    }

    @Override
    public boolean validatePasswordAtLeastOneUppercaseLetter(String password) {
        return false;
    }

    @Override
    public boolean validatePasswordAtLeastOneLowercaseLetter(String password) {
        return false;
    }

    @Override
    public boolean validatePasswordAtLeastOneSpecialCharacter(String password) {
        return false;
    }

    @Override
    public boolean validateNoRepeatedCharacters(String password) {
        return false;
    }
}
