package com.kampus.entities;

import com.kampus.core.utilities.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMMENT_MEDIA_TABLE)
public class CommentMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMMENT_MEDIA_SEQ_COMMENT_MEDIA)
    @SequenceGenerator(name = COMMENT_MEDIA_SEQ_COMMENT_MEDIA, sequenceName = COMMENT_MEDIA_SEQ_COMMENT_MEDIA_ID, allocationSize = COMMENT_MEDIA_SEQ_COMMENT_MEDIA_ID_ALLOCATION_SIZE)
    @Column(name = COMMENT_MEDIA_COLUMN_MEDIA_ID, unique = true, nullable = false)
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = COMMENT_COLUMN_COMMENT_ID, nullable = false, referencedColumnName = COMMENT_COLUMN_COMMENT_ID)
    private Comment comment;

    @Enumerated(EnumType.STRING)
    @Column(name = COMMENT_MEDIA_COLUMN_MEDIA_TYPE, nullable = false)
    private ContentType mediaType;

    @Column(name = COMMENT_MEDIA_COLUMN_MEDIA_URL, nullable = false)
    private String mediaUrl;

    @Column(name = COMMENT_MEDIA_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
}