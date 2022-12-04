package com.example.fashionblog.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalTime;


@Data
public class CommentDto {

    private Long anonId;
    private Long adminId;
    private Long postId;
    private Long clientId;
    @NotNull(message = "Comment cannot be empty")
    private String commentContent;
    private LocalTime commentTime;
}
