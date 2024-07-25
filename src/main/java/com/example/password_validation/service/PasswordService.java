package com.example.password_validation.service;

import com.example.password_validation.model.Password;
import com.example.password_validation.service.impl.PasswordRules;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;

@Service
public class PasswordService implements PasswordRules {

    private static final Log LOG = LogFactory.getLog(PasswordService.class);

    public boolean passwordValidation(Password password) {
        try {

            LOG.info("validatePasswordLength: " + validatePasswordLength(password.getPassword()));
            LOG.info("validatePasswordAtLeastOneDigit: " + validatePasswordAtLeastOneDigit(password.getPassword()));
            LOG.info("validatePasswordAtLeastOneUppercaseLetter: " + validatePasswordAtLeastOneUppercaseLetter(password.getPassword()));
            LOG.info("validatePasswordAtLeastOneLowercaseLetter: " + validatePasswordAtLeastOneLowercaseLetter(password.getPassword()));
            LOG.info("validatePasswordAtLeastOneSpecialCharacter: " + validatePasswordAtLeastOneSpecialCharacter(password.getPassword()));
            LOG.info("validateNoRepeatedCharacters: " + validateNoRepeatedCharacters(password.getPassword()));

            return validatePasswordLength(password.getPassword())
                    && validatePasswordAtLeastOneDigit(password.getPassword())
                    && validatePasswordAtLeastOneUppercaseLetter(password.getPassword())
                    && validatePasswordAtLeastOneLowercaseLetter(password.getPassword())
                    && validatePasswordAtLeastOneSpecialCharacter(password.getPassword())
                    && validateNoRepeatedCharacters(password.getPassword());

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean validatePasswordLength(String password) {
        if (password.length() >= 9)
            return true;
        return false;
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    @Override
    public boolean validatePasswordAtLeastOneDigit(String password) {
        return contains(password, Character::isDigit);
    }

    @Override
    public boolean validatePasswordAtLeastOneUppercaseLetter(String password) {
        return contains(password, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    @Override
    public boolean validatePasswordAtLeastOneLowercaseLetter(String password) {
        return contains(password, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    @Override
    public boolean validatePasswordAtLeastOneSpecialCharacter(String password) {
        boolean flagSpecialCharacter = false;
        boolean flagNotSpecialCharacter = true;

        Set<Character> specialChars = new HashSet<>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        Set<Character> notSpecialChars = new HashSet<>(
                Arrays.asList('"', ',', '.', '<', '>', ':', ';',
                        '~', '[', ']', '{', '}', '´', '`', '_', '='));

        for (char i : password.toCharArray()) {
            if (specialChars.contains(i))
                flagSpecialCharacter = true;
        }

        for (char i : password.toCharArray()) {
            if (notSpecialChars.contains(i))
                flagNotSpecialCharacter = false;
        }
        return flagSpecialCharacter && flagNotSpecialCharacter;
    }

/*    public boolean validatePasswordAtLeastOneSpecialCharacterV2(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()-+]");
        LOG.info("FIND: " + pattern.matcher(password).find());
        return pattern.matcher(password).find();
    }*/

    @Override
    public boolean validateNoRepeatedCharacters(String password) {
        if (password.chars().distinct().count() == password.length())
            return true;
        return false;
    }
}
