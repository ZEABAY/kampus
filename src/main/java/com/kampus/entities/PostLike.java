package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PostLikes")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "postlikes_seq")
    @SequenceGenerator(name = "postlikes_seq", sequenceName = "postlikes_id_seq", allocationSize = 1)
    @Column(name = "like_id", unique =true, nullable = false)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;


    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt ;

}
