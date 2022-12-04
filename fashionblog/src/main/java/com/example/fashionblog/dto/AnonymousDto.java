package com.example.fashionblog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AnonymousDto {

    @NotNull(message = "Comment section cannot be empty")
    private String anonymousComment;
    private Long postId;

}
