package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMMENT_TABLE, indexes = {
        @Index(name = COMMENT_IDX_COMMENT_POST, columnList = POST_COLUMN_POST_ID),
        @Index(name = COMMENT_IDX_COMMENT_USER, columnList = USER_COLUMN_USER_ID),
        @Index(name = COMMENT_IDX_COMMENT_CREATED_AT, columnList = COMMENT_COLUMN_CREATED_AT)
})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMMENT_SEQ_COMMENT)
    @SequenceGenerator(name = COMMENT_SEQ_COMMENT, sequenceName = COMMENT_SEQ_COMMENT_ID, allocationSize = COMMENT_SEQ_COMMENT_ID_ALLOCATION_SIZE)
    @Column(name = COMMENT_COLUMN_COMMENT_ID, unique = true, nullable = false)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = POST_COLUMN_POST_ID, nullable = false, referencedColumnName = POST_COLUMN_POST_ID)
    private Post post;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, nullable = false, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;

    //! textContext contentType olarak değiştirildi
    @Enumerated(EnumType.STRING)
    @Column(name = COMMENT_COLUMN_CONTENT_TYPE, nullable = false)
    private ContentType contentType;


    @OneToMany(mappedBy = COMMENT_MAP_COMMENT, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommentLike> likes;

    //! @CreationTimestamp ve @UpdateTimestamp
    @Column(name = COMMENT_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;


}
