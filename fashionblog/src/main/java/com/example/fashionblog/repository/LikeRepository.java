package com.example.fashionblog.repository;

import com.example.fashionblog.entity.Client;
import com.example.fashionblog.entity.Like;
import com.example.fashionblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface LikeRepository extends JpaRepository<Like, Long> {


    Optional<Like> findByClientAndPost(Client client, Post post);
}
