//package com.example.fashionblog.controller;
//
//
//import com.example.fashionblog.dto.AnonymousDto;
//import com.example.fashionblog.dto.CommentDto;
//import com.example.fashionblog.entity.Anonymous;
//import com.example.fashionblog.entity.Comment;
//import com.example.fashionblog.repository.AnonymousRepository;
//import com.example.fashionblog.repository.CommentRepository;
//import com.example.fashionblog.service.AnonymousService;
//import com.example.fashionblog.service.CommentService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//@AllArgsConstructor
//@RequestMapping("/api/v1")
//public class AnonymousController {
//
//    private AnonymousService anonymousService;
//
//    @PostMapping("/anonymous")
//    public ResponseEntity<Anonymous> toEnableAnonymousComment(@RequestBody AnonymousDto anonymousDto){
//        Anonymous anonymous = anonymousService.anonymousComment(anonymousDto);
//        return new ResponseEntity<>(anonymous, HttpStatus.CREATED);
//    }
//}
