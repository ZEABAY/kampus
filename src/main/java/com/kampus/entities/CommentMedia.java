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
@Table(name = "CommentMedias")
public class CommentMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "commentmedias_seq")
    @SequenceGenerator(name="commentmedias_seq",sequenceName = "commentmedias_id_seq",allocationSize = 1)
    @Column(name = "media_id", unique = true, nullable = false)
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false,referencedColumnName = "comment_id")
    private Comment comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false)
    private ContentType mediaType;

    @Column(name = "media_url", nullable = false)
    private String mediaUrl;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt ;
}