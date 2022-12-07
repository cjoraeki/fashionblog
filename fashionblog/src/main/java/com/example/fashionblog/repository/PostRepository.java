package com.example.fashionblog.repository;

import com.example.fashionblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query(value = "SELECT * FROM Post WHERE (postCategory LIKE 'Shirt')" , nativeQuery = true)
//    @Query(value = "-- SELECT * FROM Post u WHERE u.postCategory = ?1", nativeQuery = true)
//    List<Post> search(String keyword);

    List<Post> findAllByPostCategoryIsLikeIgnoreCase(String keyword);
}
