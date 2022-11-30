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

    @Column(length = 20)
    private String businessName;

    @Column(length = 40, unique=true)
    private String email;

    @Column(length = 10)
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Post> postSet;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Comment> commentSet;
}
