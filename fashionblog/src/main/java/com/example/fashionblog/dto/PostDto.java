package com.example.fashionblog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class PostDto {

    private Long postId;
    private Long adminId;
    @NotNull
    private String postContent;
    private Long postLikes;
    private LocalTime postTime;
}
