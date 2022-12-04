package com.example.fashionblog.dto;


import lombok.Data;
import java.time.LocalTime;


@Data
public class CommentDto {

    private Long anonId;
    private Long adminId;
    private Long postId;
    private Long clientId;
    private String commentContent;
    private Long commentLikes;
    private LocalTime commentTime;
}
