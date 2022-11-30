package com.example.fashionblog.controller;

import com.example.fashionblog.dto.AdminLoginDto;
import com.example.fashionblog.dto.AdminRegisterDto;
import com.example.fashionblog.dto.ClientLoginDto;
import com.example.fashionblog.dto.ClientSignUpDto;
import com.example.fashionblog.exception.ResourceNotFoundException;
import com.example.fashionblog.service.AdminService;
import com.example.fashionblog.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ClientController.class)
class ClientControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @AfterEach
    public void tearDown() {
    }

    @Test
    void toRegisterAdmin() throws Exception {

            ClientSignUpDto clientSignUpDto = new ClientSignUpDto();
            clientSignUpDto.setEmail("ruthy@yahoo.com");
            clientSignUpDto.setUsername("@ruthy");
            clientSignUpDto.setPassword("1234");

            String requestBody = objectMapper.writeValueAsString(clientSignUpDto);
            mockMvc.perform(post("/client/register",201)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isCreated());

    }



    @Test
    void toLoginAdmin() throws Exception {

            ClientLoginDto clientLoginDto = new ClientLoginDto();
            clientLoginDto.setEmail("gre@yahoo.com");
            clientLoginDto.setPassword("4321");

            String requestBody = objectMapper.writeValueAsString(clientLoginDto);
            mockMvc.perform(post("/client/login",202)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isAccepted());

    }

    @Test
    void toDeleteAdmin() throws Exception {

            ClientLoginDto clientLoginDto = new ClientLoginDto();
            clientLoginDto.setEmail("gre@yahoo.com");
            clientLoginDto.setPassword("4321");

            String requestBody = objectMapper.writeValueAsString(clientLoginDto);
            mockMvc.perform(delete("/client/delete",200)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isOk());

    }
}
