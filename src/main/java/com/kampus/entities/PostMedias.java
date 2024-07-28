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
@Table(name = "PostMedias")
public class PostMedias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "postmedias_seq")
    @SequenceGenerator(name="postmedias_seq",sequenceName = "postmedias_id_seq",allocationSize = 1)
    @Column(name = "media_id", unique = true, nullable = false)
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false,referencedColumnName = "post_id")
    private Posts post;

    @Column(name = "media_type", nullable = false)
    private String mediaType;

    @Column(name = "media_url", nullable = false)
    private String mediaUrl;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
}
