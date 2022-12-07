package com.example.fashionblog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.time.LocalTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private Long postId;
    private Long adminId;
//    @NotNull(message = "Post cannot be empty")
    private String postContent;
    private String postCategory;
    private LocalTime postTime;
}
