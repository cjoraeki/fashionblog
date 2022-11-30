package com.example.fashionblog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminResponseDto {

    private Long adminId;

    @NotNull(message = "Business name cannot be null/empty")
    private String businessName;

    @Email
    private String email;
}
