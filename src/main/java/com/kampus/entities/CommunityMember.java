package com.kampus.entities;

import com.kampus.core.utilities.enums.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMMUNITY_MEMBER_TABLE, indexes = {
        @Index(name = COMMUNITY_MEMBER_IDX_USER_ID, columnList = USER_COLUMN_USER_ID),
        @Index(name = COMMUNITY_MEMBER_IDX_COMMUNITY_ID, columnList = COMMUNITY_COLUMN_COMMUNITY_ID)
})
public class CommunityMember {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMMUNITY_MEMBER_SEQ_COMMUNITY)
    @SequenceGenerator(name = COMMUNITY_MEMBER_SEQ_COMMUNITY, sequenceName = COMMUNITY_MEMBER_SEQ_COMMUNITY_ID, allocationSize = COMMUNITY_MEMBER_SEQ_COMMUNITY_ID_ALLOCATION_SIZE)
    @Column(name = COMMUNITY_MEMBER_COLUMN_COMMUNITY_MEMBER_ID, unique = true, nullable = false)
    private Long communityMemberId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = COMMUNITY_COLUMN_COMMUNITY_ID, referencedColumnName = COMMUNITY_COLUMN_COMMUNITY_ID, nullable = false)
    private Community community;

    @Enumerated(EnumType.STRING)
    @Column(name = COMMUNITY_MEMBER_COLUMN_ROLE, nullable = false)
    private UserRoles role;

    @Column(name = COMMUNITY_MEMBER_COLUMN_COMMUNITY_JOINED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinedAt;
}
