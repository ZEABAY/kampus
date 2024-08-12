package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = USER_BAN_TABLE)
public class UserBan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_BAN_SEQ_USER_BAN)
    @SequenceGenerator(name = USER_BAN_SEQ_USER_BAN, sequenceName = USER_BAN_SEQ_USER_BAN_ID, allocationSize = USER_BAN_SEQ_USER_BAN_ID_ALLOCATION_SIZE)
    @Column(name = USER_BAN_COLUMN_BAN_ID, unique = true, nullable = false)
    private Long banId;

    @ManyToOne
    @JoinColumn(name = USER_COMPLAIN_REPORT_COLUMN_REPORT_ID, referencedColumnName = USER_COMPLAIN_REPORT_COLUMN_REPORT_ID)
    private UserComplainReport userComplainReport;

    @ManyToOne
    @JoinColumn(name = USER_BAN_COLUMN_BANNED_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User bannedUser;

    @ManyToOne
    @JoinColumn(name = USER_BAN_COLUMN_BANNED_BY_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User bannedByUser;

    @Column(name = USER_BAN_COLUMN_REASON)
    private String reason;

    @Column(name = USER_BAN_COLUMN_BANNED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bannedAt;

    @PrePersist
    protected void onCreate() {
        this.bannedAt = new Date();
    }

}

