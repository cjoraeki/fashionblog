package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.AnonymousDto;
import com.example.fashionblog.entity.Anonymous;
import com.example.fashionblog.entity.Post;
import com.example.fashionblog.repository.AnonymousRepository;
import com.example.fashionblog.repository.PostRepository;
import com.example.fashionblog.service.AnonymousService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AnonymousServiceImpl implements AnonymousService {

    private final PostRepository postRepository;
    private final AnonymousRepository anonymousRepository;

    @Override
    public Anonymous anonComment(AnonymousDto anonymousDto) {

        Post post = postRepository.findById(anonymousDto.getPostId()).get();
        Anonymous anonymous = new Anonymous();
        anonymous.setAnonymousComment(anonymousDto.getAnonymousComment());
        anonymous.setPost(post);

        return anonymousRepository.save(anonymous);
    }
}
