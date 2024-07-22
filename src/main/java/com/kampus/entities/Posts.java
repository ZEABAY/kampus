package com.kampus.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="posts_seq",sequenceName = "posts_id_seq",allocationSize = 1)
    @Column(name = "post_id")
    UUID postId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "text_content")
    private String textContent;

    /*
     LİKE COUNT
     COMMENT COUNT

     */
    @Column(name = "created_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;






}
