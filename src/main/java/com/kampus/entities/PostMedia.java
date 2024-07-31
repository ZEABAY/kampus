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
@Table(name = "PostMedias", indexes = {
        @Index(name = "idx_postmedia_post", columnList = "post_id"),
        @Index(name = "idx_postmedia_created_at", columnList = "created_at")
})
public class PostMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postmedias_seq")
    @SequenceGenerator(name = "postmedias_seq", sequenceName = "postmedias_id_seq", allocationSize = 1)
    @Column(name = "media_id", unique = true, nullable = false)
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false, referencedColumnName = "post_id")
    private Post post;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false)
    private ContentType mediaType;

    @Column(name = "media_url", nullable = false)
    private String mediaUrl;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
