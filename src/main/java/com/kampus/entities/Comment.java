package com.kampus.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comments_seq")
    @SequenceGenerator(name = "comments_seq",sequenceName = "comments_id_seq",allocationSize = 1)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false,referencedColumnName = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;

    @Column(name = "text_content")
    private String textContent;

    @OneToMany(mappedBy = "comments", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommentLike> likes;
}
