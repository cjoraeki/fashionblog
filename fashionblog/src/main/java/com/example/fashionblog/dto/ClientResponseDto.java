package com.example.fashionblog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientResponseDto {

    private Long clientId;

    @NotNull(message = "Username cannot be missing or empty")
    @Size(min = 2, message = "Username cannot be less than 2 characters")
    private String username;

    @Email
    private String email;
}
