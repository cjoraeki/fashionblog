package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.ClientResponseDto;
import com.example.fashionblog.dto.CommentDto;
import com.example.fashionblog.entity.*;
import com.example.fashionblog.repository.*;
import com.example.fashionblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment clientComment(CommentDto commentDto, ClientResponseDto clientResponseDto) {
        Client client = new Client();
        client.setClientId(commentDto.getClientId());
        Post post = new Post();
        post.setPostId(commentDto.getPostId());
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        comment.setClient(client);
        comment.setPost(post);

        return commentRepository.save(comment);
    }


    @Override
    public Comment adminComment(CommentDto commentDto){
        Admin admin = new Admin();
        admin.setAdminId(commentDto.getAdminId());
        Post post = new Post();
        post.setPostId(commentDto.getPostId());
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        comment.setAdmin(admin);
        comment.setPost(post);

        return commentRepository.save(comment);
    }


}
