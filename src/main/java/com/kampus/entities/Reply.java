package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.CommentConstants.COMMENT_COLUMN_COMMENT_ID;
import static com.kampus.core.constants.entityConstants.ReplyConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = REPLY_TABLE, indexes = {
        @Index(name = REPLY_IDX_REPLY_USER, columnList = USER_COLUMN_USER_ID),
        @Index(name = REPLY_IDX_REPLY_COMMENT, columnList = COMMENT_COLUMN_COMMENT_ID),
        @Index(name = REPLY_IDX_REPLY_CREATED_AT, columnList = REPLY_COLUMN_CREATED_AT)
})
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = REPLY_SEQ_REPLY)
    @SequenceGenerator(name = REPLY_SEQ_REPLY, sequenceName = REPLY_SEQ_REPLY_ID, allocationSize = REPLY_SEQ_REPLY_ID_ALLOCATION_SIZE)
    @Column(name = REPLY_COLUMN_REPLY_ID, unique = true, nullable = false)
    private Long replyId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, nullable = false, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;

    @ManyToOne
    @JoinColumn(name = COMMENT_COLUMN_COMMENT_ID, nullable = false, referencedColumnName = COMMENT_COLUMN_COMMENT_ID)
    private Comment comment;

    @Column(name = REPLY_COLUMN_LIKE_COUNT, nullable = false)
    private Integer likeCount;

    @Enumerated(EnumType.STRING)
    @Column(name = REPLY_COLUMN_CONTENT_TYPE, nullable = false)
    private ContentType contentType;

    @Column(name = REPLY_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }

}
