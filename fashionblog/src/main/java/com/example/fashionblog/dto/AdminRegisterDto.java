package com.example.fashionblog.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class AdminRegisterDto {

    private Long adminId;

    @NotNull(message = "Business name cannot be missing or empty")
    @Size(min = 2, message = "Business name cannot be less than 2 characters")
    private String businessName;

    @Email
    private String email;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 4, max = 16, message = "Password cannot be less than 4 ro more than 16")
    private String password;
}
