package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.FollowerConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = FOLLOWER_TABLE, indexes = {
        @Index(name = FOLLOWER_IDX_FOLLOWER, columnList = FOLLOWER_COLUMN_FOLLOWER_ID),
        @Index(name = FOLLOWER_IDX_FOLLOWED, columnList = FOLLOWER_COLUMN_FOLLOWER_ID),
        @Index(name = FOLLOWER_IDX_STATUS, columnList = FOLLOWER_COLUMN_STATUS)
})
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = FOLLOWER_SEQ_FOLLOWER)
    @SequenceGenerator(name = FOLLOWER_SEQ_FOLLOWER, sequenceName = FOLLOWER_SEQ_FOLLOWER_ID, allocationSize = FOLLOWER_SEQ_FOLLOWER_ID_ALLOCATION_SIZE)
    @Column(name = FOLLOWER_COLUMN_FOLLOWER_ID, unique = true, nullable = false)
    private Long followerId;

    @ManyToOne
    @JoinColumn(name = FOLLOWER_COLUMN_FOLLOWER_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User followerUser;

    @ManyToOne
    @JoinColumn(name = FOLLOWER_COLUMN_FOLLOWED_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User followedUser;

    @Column(name = FOLLOWER_COLUMN_STATUS)
    private String status;

    @Column(name = FOLLOWER_COLUMN_CREATED_AT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
}