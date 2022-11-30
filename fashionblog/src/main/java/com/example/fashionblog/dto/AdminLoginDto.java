package com.example.fashionblog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminLoginDto {

    private Long adminId;

    @Email
    private String email;

    @NotNull
    @Size(min = 4, max = 16, message = "Password cannot be less than 3 or more than 16")
    private String password;
}
