package com.kampus.entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CommentLikes")
public class CommentLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "commentlikes_seq")
    @SequenceGenerator(name = "commentlikes_seq",sequenceName = "commentslikes_id_seq",allocationSize = 1)
    @Column(name = "like_id", unique = true, nullable = false)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false,referencedColumnName = "comment_id")
    private Comments comments;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

}
