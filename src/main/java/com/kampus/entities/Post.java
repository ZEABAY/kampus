package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "posts_seq")
    @SequenceGenerator(name = "posts_seq", sequenceName = "posts_id_seq", allocationSize = 1)
    @Column(name = "post_id")
    Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "text_content")
    private String textContent;


    /*
    bir Post nesnesi silindiğinde, ona bağlı tüm PostLikes nesnelerinin de otomatik olarak silineceğini belirtir.
    db deki cascade mantığı
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostLike> likes = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;


    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

    @Column(name = "comment_count", nullable = false)
    private Integer commentCount = 0;


    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


}
