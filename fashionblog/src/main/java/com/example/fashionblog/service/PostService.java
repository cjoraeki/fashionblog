package com.example.fashionblog.service;


import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.entity.Post;

public interface PostService {

    Post makePost(PostDto postDto);

    void deletePost(PostDto postDto);
}
