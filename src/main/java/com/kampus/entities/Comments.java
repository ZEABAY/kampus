package com.kampus.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "text_content")
    private String textContent;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

}
