package com.example.password_validation.service;

import com.example.password_validation.model.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceTest {

    @InjectMocks
    private PasswordService passwordService;


    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("validPassword")
    void testPasswordValid(Password password) {
        assertTrue(passwordService.passwordValidation(password));
    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("invalidPassword")
    void testPasswordInvalid(Password password) {
        assertFalse(passwordService.passwordValidation(password));
    }

    @Test
    @DisplayName("Test With Some Exception")
    void testCatchSomeException() {
        assertFalse(passwordService.passwordValidation(null));
    }

    static Stream<String> validPassword() {
        return Stream.of(
                "A!@#&()–a1",
                "0123456789$abcdefgAB",
                "jav REGAX123%",
                "AbTp9!fok"
        );
    }

    static Stream<String> invalidPassword() {
        return Stream.of("Hello world$123",
                "123Aa$Aa",
                "A~$^+=<>a1",
                "A[{}]:;',?/*a1",
                "AAAbbbccc@123",
                "12345678",
                "abcdefgh",
                "ABCDEFGH",
                "abc123$$$",
                "ABC123$$$",
                "AbTp9!foA",
                "AbTp9 fok",
                "bTp9!foo",
                " ",
                "");
    }
}
