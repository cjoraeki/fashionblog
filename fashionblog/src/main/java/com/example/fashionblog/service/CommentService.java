package com.example.fashionblog.service;


import com.example.fashionblog.dto.ClientResponseDto;
import com.example.fashionblog.dto.CommentDto;
import com.example.fashionblog.entity.Comment;

public interface CommentService {

    Comment clientComment(CommentDto commentDto, ClientResponseDto clientResponseDto);
    Comment adminComment(CommentDto commentDto);
//    Comment anonymousComment(Comment comment);

}
