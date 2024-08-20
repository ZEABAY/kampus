package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = POST_TABLE, indexes = {
        @Index(name = POST_IDX_POST_USER, columnList = USER_COLUMN_USER_ID),
        @Index(name = POST_IDX_POST_CREATED_AT, columnList = POST_COLUMN_CREATED_AT),
        @Index(name = POST_IDX_POST_UPDATED_AT, columnList = POST_COLUMN_UPDATED_AT)
})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = POST_SEQ_POST)
    @SequenceGenerator(name = POST_SEQ_POST, sequenceName = POST_SEQ_POST_ID, allocationSize = POST_SEQ_POST_ID_ALLOCATION_SIZE)
    @Column(name = POST_COLUMN_POST_ID, nullable = false, unique = true)
    Long postId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = POST_COLUMN_CONTENT_TYPE, nullable = false)
    private ContentType contentType;

    @Column(name = POST_COLUMN_TEXT_CONTENT, nullable = false)
    private String textContent;

    @OneToMany(mappedBy = POST_MAP_POSTS, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostLike> likes;

    @OneToMany(mappedBy = POST_MAP_POSTS, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;


    @Column(name = POST_COLUMN_LIKE_COUNT, nullable = false)
    private int likeCount;

    @Column(name = POST_COLUMN_COMMENT_COUNT, nullable = false)
    private int commentCount;


    @Column(name = POST_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = POST_COLUMN_UPDATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.likeCount = 0;
        this.commentCount = 0;
    }
}
