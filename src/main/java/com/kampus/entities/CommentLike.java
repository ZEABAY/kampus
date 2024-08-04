package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.CommentConstants.COMMENT_COLUMN_COMMENT_ID;
import static com.kampus.core.constants.entityConstants.CommentLikeConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMMENT_LIKE_TABLE, indexes = {
        @Index(name = COMMENT_LIKE_IDX_COMMENT_LIKE_COMMENT, columnList = COMMENT_COLUMN_COMMENT_ID),
        @Index(name = COMMENT_LIKE_IDX_COMMENT_LIKE_USER, columnList = USER_COLUMN_USER_ID)
})
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMMENT_LIKE_SEQ_COMMENT_LIKE)
    @SequenceGenerator(name = COMMENT_LIKE_SEQ_COMMENT_LIKE, sequenceName = COMMENT_LIKE_SEQ_COMMENT_LIKE_ID, allocationSize = COMMENT_LIKE_SEQ_COMMENT_LIKE_ID_ALLOCATION_SIZE)
    @Column(name = COMMENT_LIKE_COLUMN_LIKE_ID, unique = true, nullable = false)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = COMMENT_COLUMN_COMMENT_ID, nullable = false, referencedColumnName = COMMENT_COLUMN_COMMENT_ID)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, nullable = false, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;

    @Column(name = COMMENT_LIKE_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
}
