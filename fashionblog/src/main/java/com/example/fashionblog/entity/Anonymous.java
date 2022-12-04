package com.example.fashionblog.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "anonymous")
public class Anonymous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anonId;

    private String anonymousComment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @OneToMany(mappedBy = "anonymous", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Like> likeSet;
}
