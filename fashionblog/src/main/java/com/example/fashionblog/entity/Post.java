package com.example.fashionblog.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String postContent;

    private String postCategory;

    @CreationTimestamp
    private LocalTime postTime;

    @ManyToOne
    @JoinColumn(name = "adminId", nullable = false)
    private Admin admin;

}
