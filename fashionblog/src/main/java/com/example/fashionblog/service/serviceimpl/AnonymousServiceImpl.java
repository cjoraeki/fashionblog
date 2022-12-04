package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.AnonymousDto;
import com.example.fashionblog.entity.Anonymous;
import com.example.fashionblog.entity.Post;
import com.example.fashionblog.repository.AnonymousRepository;
import com.example.fashionblog.service.AnonymousService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnonymousServiceImpl implements AnonymousService {

    private final AnonymousRepository anonymousRepository;

    @Override
    public Anonymous anonymousComment(AnonymousDto anonymousDto) {
        Post post = new Post();
        post.setPostId(anonymousDto.getPostId());
        Anonymous anonymous = new Anonymous();
        anonymous.setAnonymousComment(anonymousDto.getAnonymousComment());
        anonymous.setPost(post);

        return anonymousRepository.save(anonymous);
    }
}
