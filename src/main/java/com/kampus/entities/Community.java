package com.kampus.entities;

import com.kampus.core.constants.entityConstants.CommunityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

import static com.kampus.core.constants.entityConstants.CommentConstants.*;
import static com.kampus.core.constants.entityConstants.CommunityConstants.*;
import static com.kampus.core.constants.entityConstants.PostConstants.POST_COLUMN_POST_ID;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMMUNITY_TABLE, indexes = {
        @Index(name = COMMUNITY_SEQ_COMMUNITY, columnList = COMMUNITY_COLUMN_COMMUNITY_ID),
})
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMMUNITY_SEQ_COMMUNITY)
    @SequenceGenerator(name = COMMUNITY_SEQ_COMMUNITY, sequenceName = COMMENT_SEQ_COMMENT_ID, allocationSize = COMMUNITY_SEQ_COMMUNITY_ID_ALLOCATION_SIZE)
    @Column(name = COMMUNITY_COLUMN_COMMUNITY_ID, unique = true, nullable = false)
    private Long commentId;

    @Column(name = COMMUNITY_COLUMN_NAME)
    private  String name;

    @Column(name = COMMUNITY_COLUMN_DESCRIPTION)
    private  String description;

    @OneToMany(mappedBy = COMMUNITY_MAP_COMMUNITY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommunityMember> members;

    @Column(name = COMMUNITY_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }




}
