package com.kampus.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMMUNITY_TABLE, indexes = {
        @Index(name = COMMUNITY_IDX_COMMUNITY_ID, columnList = COMMUNITY_COLUMN_COMMUNITY_ID),
})
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMMUNITY_SEQ_COMMUNITY)
    @SequenceGenerator(name = COMMUNITY_SEQ_COMMUNITY, sequenceName = COMMUNITY_SEQ_COMMUNITY_ID, allocationSize = COMMUNITY_SEQ_COMMUNITY_ID_ALLOCATION_SIZE)
    @Column(name = COMMUNITY_COLUMN_COMMUNITY_ID, unique = true, nullable = false)
    private Long communityId;

    @Column(name = COMMUNITY_COLUMN_NAME, nullable = false)
    private String name;

    @Column(name = COMMUNITY_COLUMN_DESCRIPTION)
    private String description;

    @ManyToOne
    @JoinColumn(name = COMMUNITY_COLUMN_COMMUNITY_CREATED_BY, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @OneToMany(mappedBy = COMMUNITY_MAP_COMMUNITY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommunityMember> members;

    @Column(name = COMMUNITY_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
}
