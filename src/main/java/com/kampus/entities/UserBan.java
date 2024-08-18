package com.kampus.entities;

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
@Table(name = USER_BAN_TABLE, indexes = {
        @Index(name = USER_BAN_IDX_BANNED_USER, columnList = USER_BAN_COLUMN_BANNED_USER_ID),
        @Index(name = USER_BAN_IDX_BANNED_BY_USER, columnList = USER_BAN_COLUMN_BANNED_BY_USER_ID),
        @Index(name = USER_BAN_IDX_BANNED_AT, columnList = USER_BAN_COLUMN_BANNED_AT)
})
public class UserBan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_BAN_SEQ_USER_BAN)
    @SequenceGenerator(name = USER_BAN_SEQ_USER_BAN, sequenceName = USER_BAN_SEQ_USER_BAN_ID, allocationSize = USER_BAN_SEQ_USER_BAN_ID_ALLOCATION_SIZE)
    @Column(name = USER_BAN_COLUMN_BAN_ID, unique = true, nullable = false)
    private Long banId;

    @ManyToOne
    @JoinColumn(name = USER_COMPLAIN_REPORT_COLUMN_REPORT_ID, referencedColumnName = USER_COMPLAIN_REPORT_COLUMN_REPORT_ID, nullable = false)
    private UserComplainReport userComplainReport;

    @ManyToOne
    @JoinColumn(name = USER_BAN_COLUMN_BANNED_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User bannedUser;

    @ManyToOne
    @JoinColumn(name = USER_BAN_COLUMN_BANNED_BY_USER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User bannedByUser;

    @Column(name = USER_BAN_COLUMN_REASON, nullable = false)
    private String reason;

    @Column(name = USER_BAN_COLUMN_BANNED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date bannedAt;
}

