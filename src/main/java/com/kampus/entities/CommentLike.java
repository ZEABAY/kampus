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
@Table(name = "CommentLikes", indexes = {
        @Index(name = "idx_commentlike_comment", columnList = "comment_id"),
        @Index(name = "idx_commentlike_user", columnList = "user_id")
})
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentlikes_seq")
    @SequenceGenerator(name = "commentlikes_seq", sequenceName = "commentslikes_id_seq", allocationSize = 1)
    @Column(name = "like_id", unique = true, nullable = false)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false, referencedColumnName = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
