package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.LikeDto;
import com.example.fashionblog.entity.Client;
import com.example.fashionblog.entity.Like;
import com.example.fashionblog.entity.Post;
import com.example.fashionblog.repository.LikeRepository;
import com.example.fashionblog.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public Like likeAndUnlikePost(LikeDto likeDto){
        Client client = new Client();
        client.setClientId(likeDto.getClientId());
        Post post = new Post();
        post.setPostId(likeDto.getPostId());
        Like like = new Like();
        like.setClient(client);
        like.setPost(post);

        Like like1 = likeRepository.findByClientAndPost(client,post).orElse(null);
            if (like1 != null){
                likeRepository.delete(like1);
        }else {
                likeRepository.save(like);
        }
            return like;
    }
}
