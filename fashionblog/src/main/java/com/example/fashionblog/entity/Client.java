package com.example.fashionblog.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "likeId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Like> likeSet;

    @OneToMany(mappedBy = "commentId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Comment> commentSet;

}
