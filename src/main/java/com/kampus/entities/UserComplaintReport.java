package com.kampus.entities;

import com.kampus.core.utilities.enums.ReportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserComplaintReports")
public class UserComplaintReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_complaint_reports_seq")
    @SequenceGenerator(name = "user_complaint_reports_seq", sequenceName = "user_complaint_reports_id_seq", allocationSize = 1)
    @Column(name = "report_id", unique = true, nullable = false)
    private Long reportId;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type", nullable = false)
    private ReportType reportType;


    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private Comment comments;


    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id")
    private Message message;

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
    private Date createdAt;
}