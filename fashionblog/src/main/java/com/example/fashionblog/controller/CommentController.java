package com.example.fashionblog.controller;


import com.example.fashionblog.dto.AnonymousDto;
import com.example.fashionblog.dto.ClientResponseDto;
import com.example.fashionblog.dto.CommentDto;
import com.example.fashionblog.entity.Anonymous;
import com.example.fashionblog.entity.Comment;
import com.example.fashionblog.service.AnonymousService;
import com.example.fashionblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    public AnonymousService anonymousService;
    public CommentService commentService;

    @PostMapping("/client")
    public ResponseEntity<Comment> clientCommentToPost( @RequestBody CommentDto commentDto, ClientResponseDto clientResponseDto){
        Comment comment = commentService.clientComment(commentDto, clientResponseDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<Comment> adminCommentToPost( @RequestBody CommentDto commentDto){
        Comment comment = commentService.adminComment(commentDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PostMapping("/anonymous")
    public ResponseEntity<Anonymous> anonymousCommentToPost(@RequestBody AnonymousDto anonymousDto){
        Anonymous anonymous = anonymousService.anonymousComment(anonymousDto);
        return new ResponseEntity<>(anonymous, HttpStatus.CREATED);
    }
}
