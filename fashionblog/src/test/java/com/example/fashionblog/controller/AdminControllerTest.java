package com.example.fashionblog.controller;

import com.example.fashionblog.dto.AdminLoginDto;
import com.example.fashionblog.dto.AdminRegisterDto;
import com.example.fashionblog.exception.ResourceNotFoundException;
import com.example.fashionblog.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.After;
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


@WebMvcTest(controllers = AdminController.class)
class AdminControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @AfterEach
    public void tearDown() {
    }

    @Test
    void toRegisterAdmin() throws Exception {

            AdminRegisterDto adminRegisterDto = new AdminRegisterDto();
            adminRegisterDto.setAdminId(1L);
            adminRegisterDto.setBusinessName("deledesigns");
            adminRegisterDto.setEmail("deledesigns@yahoo.com");
            adminRegisterDto.setPassword("0000");

            String requestBody = objectMapper.writeValueAsString(adminRegisterDto);
            mockMvc.perform(post("/admin/register",201)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isCreated());

    }





    @Test
    void toLoginAdmin() throws Exception {

            AdminLoginDto adminLoginDto = new AdminLoginDto();
            adminLoginDto.setEmail("deledesigns@yahoo.com");
            adminLoginDto.setPassword("0000");

            String requestBody = objectMapper.writeValueAsString(adminLoginDto);
            mockMvc.perform(post("/admin/login",202)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isAccepted());

    }

    @Test
    void toDeleteAdmin() throws Exception {

            AdminLoginDto adminLoginDto = new AdminLoginDto();
            adminLoginDto.setEmail("deledesigns@yahoo.com");
            adminLoginDto.setPassword("0000");

            String requestBody = objectMapper.writeValueAsString(adminLoginDto);
            mockMvc.perform(delete("/admin/delete",200)
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isOk());

    }
}