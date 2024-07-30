package com.kampus.entities;
import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Replies", indexes = {
        @Index(name = "idx_reply_user", columnList = "user_id"),
        @Index(name = "idx_reply_comment", columnList = "comment_id"),
        @Index(name = "idx_reply_created_at", columnList = "created_at")
})
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reply_seq")
    @SequenceGenerator(name = "reply_seq",sequenceName = "reply_id_seq",allocationSize = 1)
    @Column(name = "reply_id", unique = true, nullable = false)
    private Long replyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false,referencedColumnName = "comment_id")
    private Comment comment;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    private ContentType contentType;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt ;

}
