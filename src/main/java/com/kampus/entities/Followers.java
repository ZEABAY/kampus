package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Followers")
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "followers_seq", sequenceName = "followers_id_seq")
    @Column(name = "followers_id")
    private Long followersId;

    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "user_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followed_id", referencedColumnName = "user_id")
    private User followed;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
}
