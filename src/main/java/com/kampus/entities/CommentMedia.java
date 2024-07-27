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
@Table(name = "CommentMedias")
public class CommentMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "commentmedias_seq")
    @SequenceGenerator(name="commentmedias_seq",sequenceName = "commentmedias_id_seq",allocationSize = 1)
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false,referencedColumnName = "comment_id")
    private Comment comment;

    @Column(name = "media_type", nullable = false)
    private String mediaType;

    @Column(name = "media_url", nullable = false)
    private String mediaUrl;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}