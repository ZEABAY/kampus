package com.kampus.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comments_seq")
    @SequenceGenerator(name = "comments_seq",sequenceName = "comments_id_seq",allocationSize = 1)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false,referencedColumnName = "post_id")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;

    @Column(name = "text_content")
    private String textContent;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

}
