package com.example.fashionblog.controller;


import com.example.fashionblog.dto.LikeDto;
import com.example.fashionblog.entity.Like;
import com.example.fashionblog.service.LikeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private LikeService likeService;

    @PostMapping("/likepost")
    public ResponseEntity<Like> toLikeAPostOnClick(@Valid @RequestBody LikeDto likeDto){
        Like like = likeService.likeAndUnlikePost(likeDto);
        return new ResponseEntity<>(like, HttpStatus.ACCEPTED);
    }
}
