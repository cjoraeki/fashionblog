package com.example.fashionblog.controller;


import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.entity.Post;
import com.example.fashionblog.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> toCreateAPost( @RequestBody PostDto postDto){
        Post post = postService.makePost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> toEditAPost(@Valid @RequestBody PostDto postDto){
        postService.editPost(postDto);
        return new ResponseEntity<>("Post edited", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPostByAdmin(){
        List<PostDto> post = postService.getAllPosts();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> toDeleteAPost(@Valid @RequestBody PostDto postDto){
        postService.deletePost(postDto);
        return new ResponseEntity<>("Post deleted", HttpStatus.OK);
    }

    @RequestMapping("/search/{searchTerm}")
    public ResponseEntity<List<PostDto>> viewHomePage(@PathVariable String searchTerm) {
        List<PostDto> listPosts = postService.listAll(searchTerm);

        return new ResponseEntity<>(listPosts, HttpStatus.FOUND);
    }

}
