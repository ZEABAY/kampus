package com.kampus.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "UserComplaintReports")
public class UserComplaintReports {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_complaint_reports_seq")
    @SequenceGenerator(name = "user_complaint_reports_seq", sequenceName = "user_complaint_reports_id_seq", allocationSize = 1)
    @Column(name = "report_id", unique = true, nullable = false)
    private Long reportId;

    @Column(name = "report_type", nullable = false)
    private String reportType;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private Comment comments;

    /*
    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id")
    private Messages message;
     */
    @ManyToOne
    @JoinColumn(name = "reply_id", referencedColumnName = "reply_id")
    private Reply replies;

    @ManyToOne
    @JoinColumn(name = "reporter_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reported_id", nullable = false, referencedColumnName = "user_id")
    private User reportedUser;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
}