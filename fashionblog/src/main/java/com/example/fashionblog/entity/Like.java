package com.example.fashionblog.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = true)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = true)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "anonId", nullable = true)
    private Anonymous anonymous;
}
