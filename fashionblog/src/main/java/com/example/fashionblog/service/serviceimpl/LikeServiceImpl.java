package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.LikeDto;
import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.entity.Admin;
import com.example.fashionblog.entity.Client;
import com.example.fashionblog.entity.Like;
import com.example.fashionblog.entity.Post;
import com.example.fashionblog.repository.AdminRepository;
import com.example.fashionblog.repository.ClientRepository;
import com.example.fashionblog.repository.LikeRepository;
import com.example.fashionblog.repository.PostRepository;
import com.example.fashionblog.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final ClientRepository clientRepository;

    @Override
    public Like likePost(LikeDto likeDto){
        Client client = clientRepository.findById(likeDto.getClientId()).get();
        client.setClientId(likeDto.getClientId());
        Post post = postRepository.findById(likeDto.getPostId()).get();
        post.setPostId(likeDto.getPostId());

        Like like = new Like();
        if(like.getLikePost() == 0L){
            like.setLikePost(likeDto.getLikePost() + 1);
        }



        return likeRepository.save(like);
    }
}
