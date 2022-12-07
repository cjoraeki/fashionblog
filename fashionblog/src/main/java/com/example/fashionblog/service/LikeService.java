package com.example.fashionblog.service;


import com.example.fashionblog.dto.LikeDto;
import com.example.fashionblog.entity.Like;

public interface LikeService {

    Like likeAndUnlikePost(LikeDto likeDto);
}
