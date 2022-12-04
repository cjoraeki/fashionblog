package com.example.fashionblog.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String businessName;

    @Column(unique=true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Post> postSet;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Comment> commentSet;
}
