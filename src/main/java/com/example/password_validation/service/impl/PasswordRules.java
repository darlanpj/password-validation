package com.example.password_validation.service.impl;

public interface PasswordRules {

    boolean validatePasswordLength(String password);

    boolean validatePasswordAtLeastOneDigit(String password);

    boolean validatePasswordAtLeastOneUppercaseLetter(String password);

    boolean validatePasswordAtLeastOneLowercaseLetter(String password);

    boolean validatePasswordAtLeastOneSpecialCharacter(String password);

    boolean validateNoRepeatedCharacters(String password);
}
