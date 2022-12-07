package com.example.fashionblog.service;


import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.entity.Post;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface PostService {

    Post makePost(PostDto postDto);
    Post editPost(PostDto postDto);
    void deletePost(PostDto postDto);
    List<PostDto> getAllPosts( );
    List<PostDto> listAll(String keyword);

}
