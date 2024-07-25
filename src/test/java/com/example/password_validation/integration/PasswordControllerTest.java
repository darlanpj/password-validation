package com.example.password_validation.integration;


import com.example.password_validation.model.Password;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private static final String URL_TEMPLATE = "/api/v1/validation/password";

    @ParameterizedTest
    @DisplayName("Validation case 1 - Jwt validation ok")
    @ValueSource(strings = {"AbTp9 fok", "A[{}]:;',?/*a1", "+AAAbbbCc"})
    void testPasswordInvalid(String passwordInput) throws Exception {
        Password password = new Password();
        password.setPassword(passwordInput);
        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(password)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));

    }

    @ParameterizedTest
    @DisplayName("Test Controller - valid password")
    @ValueSource(strings = {"AbTp9!fok", "0123456789$abcdefgAB", "jav REGAX123%"})
    void testPasswordValid(String passwordInput) throws Exception {
        Password password = new Password();
        password.setPassword(passwordInput);
        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(password)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
}
