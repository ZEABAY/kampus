package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.PostConstants.POST_COLUMN_POST_ID;
import static com.kampus.core.constants.entityConstants.PostLikeConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = POST_LIKE_TABLE, indexes = {
        @Index(name = POST_LIKE_IDX_POST_LIKE_POST, columnList = POST_COLUMN_POST_ID),
        @Index(name = POST_LIKE_IDX_POST_LIKE_USER, columnList = USER_COLUMN_USER_ID)
})
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = POST_LIKE_SEQ_POST_LIKE)
    @SequenceGenerator(name = POST_LIKE_SEQ_POST_LIKE, sequenceName = POST_LIKE_SEQ_POST_LIKE_ID, allocationSize = POST_LIKE_SEQ_POST_LIKE_ID_ALLOCATION_SIZE)
    @Column(name = POST_LIKE_COLUMN_LIKE_ID, unique = true, nullable = false)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = POST_COLUMN_POST_ID, nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, nullable = false, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;


    @Column(name = POST_LIKE_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

}
