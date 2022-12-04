package com.example.fashionblog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class PostDto {

    private Long postId;
    private Long adminId;
    @NotNull(message = "Post cannot be empty")
    private String postContent;
    private String postCategory;
    private LocalTime postTime;
}
