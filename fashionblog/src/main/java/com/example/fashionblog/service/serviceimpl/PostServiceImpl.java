package com.example.fashionblog.service.serviceimpl;


import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.entity.Admin;
import com.example.fashionblog.entity.Post;
import com.example.fashionblog.repository.AdminRepository;
import com.example.fashionblog.repository.PostRepository;
import com.example.fashionblog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final AdminRepository adminRepository;

    @Override
    public Post makePost(PostDto postDto) {
        Admin admin = new Admin();
        admin.setAdminId(postDto.getAdminId());
        Post post = new Post();
        post.setPostId(postDto.getPostId());
        post.setPostTime(LocalTime.now());
        post.setPostContent(postDto.getPostContent());
        post.setPostCategory(postDto.getPostCategory());
        post.setAdmin(admin);

        return postRepository.save(post);
    }

    @Override
    public Post editPost(PostDto postDto){
        Admin admin = new Admin();
        admin.setAdminId(postDto.getAdminId());
        Post post = postRepository.findById(postDto.getPostId()).get();
        post.setPostContent(postDto.getPostContent());
        post.setAdmin(admin);

        return postRepository.save(post);
    }


    @Override
    public List<PostDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();

        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(post -> {
            PostDto postDto = new PostDto();
            BeanUtils.copyProperties(post, postDto);
            postDto.setAdminId(post.getAdmin().getAdminId());
            postDtos.add(postDto);
        });

        return postDtos;
    }

    @Override
    public void deletePost(PostDto postDto){
        postRepository.deleteById(postDto.getPostId());
    }


    @Override
    public List<PostDto> listAll(String keyword){
            List<Post> posts = postRepository.findAllByPostCategoryIsLikeIgnoreCase(keyword);
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(post -> {
            PostDto postDto = new PostDto();
            BeanUtils.copyProperties(post, postDto);
            postDto.setAdminId(post.getAdmin().getAdminId());
            postDtos.add(postDto);
        });

        return postDtos;
    }
}
