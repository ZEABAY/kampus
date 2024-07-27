package com.kampus.entities;
import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reply_seq")
    @SequenceGenerator(name = "reply_seq",sequenceName = "reply_id_seq",allocationSize = 1)
    private Long replyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false,referencedColumnName = "comment_id")
    private Comment comment;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

    @Column(name = "text_content")
    private String textContent;

    /*

    Bunu bir ara konuşalım hangisi daha iyi olur diye
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    private ContentType contentType;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

}
