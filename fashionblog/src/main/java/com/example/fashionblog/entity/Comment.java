package com.example.fashionblog.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentContent;

    @CreationTimestamp
    private LocalTime commentTime;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;


    @ManyToOne
    @JoinColumn(name = "adminId", nullable = true)
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = true)
    private Client client;

}
