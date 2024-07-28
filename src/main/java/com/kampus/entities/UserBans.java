package com.kampus.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "UserBans")
public class UserBans {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_bans_seq")
    @SequenceGenerator(name = "user_bans_seq", sequenceName = "user_bans_id_seq", allocationSize = 1)
    @Column(name = "ban_id", unique = true, nullable = false)
    private Long banId;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    private UserComplaintReports userComplaintReports;

    @ManyToOne
    @JoinColumn(name = "banned_user_id", referencedColumnName = "user_id")
    private User banned;

    @ManyToOne
    @JoinColumn(name = "banned_by_user_id", referencedColumnName = "user_id")
    private User bannedBy;

    @Column(name = "reason")
    private String reason;

    @Column(name = "banned_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bannedAt = new Date();

}

