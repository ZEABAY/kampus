package com.kampus.entities;

import com.kampus.core.utilities.enums.ReportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.kampus.core.constants.entityConstants.CommentConstants.COMMENT_COLUMN_COMMENT_ID;
import static com.kampus.core.constants.entityConstants.MessageConstants.MESSAGE_COLUMN_MESSAGE_ID;
import static com.kampus.core.constants.entityConstants.PostConstants.POST_COLUMN_POST_ID;
import static com.kampus.core.constants.entityConstants.ReplyConstants.REPLY_COLUMN_REPLY_ID;
import static com.kampus.core.constants.entityConstants.UserComplainReportConstants.*;
import static com.kampus.core.constants.entityConstants.UserConstants.USER_COLUMN_USER_ID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = USER_COMPLAIN_REPORT_TABLE)
public class UserComplainReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT)
    @SequenceGenerator(name = USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT, sequenceName = USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT_ID, allocationSize = USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT_ID_ALLOCATION_SIZE)
    @Column(name = USER_COMPLAIN_REPORT_COLUMN_REPORT_ID, unique = true, nullable = false)
    private Long reportId;

    @Enumerated(EnumType.STRING)
    @Column(name = USER_COMPLAIN_REPORT_COLUMN_REPORT_TYPE, nullable = false)
    private ReportType reportType;


    @ManyToOne
    @JoinColumn(name = POST_COLUMN_POST_ID, referencedColumnName = POST_COLUMN_POST_ID)
    private Post post;

    @ManyToOne
    @JoinColumn(name = COMMENT_COLUMN_COMMENT_ID, referencedColumnName = COMMENT_COLUMN_COMMENT_ID)
    private Comment comment;


    @ManyToOne
    @JoinColumn(name = MESSAGE_COLUMN_MESSAGE_ID, referencedColumnName = MESSAGE_COLUMN_MESSAGE_ID)
    private Message message;

    @ManyToOne
    @JoinColumn(name = REPLY_COLUMN_REPLY_ID, referencedColumnName = REPLY_COLUMN_REPLY_ID)
    private Reply reply;

    @ManyToOne
    @JoinColumn(name = USER_COMPLAIN_REPORT_COLUMN_REPORTER_ID, nullable = false, referencedColumnName = USER_COLUMN_USER_ID)
    private User reporterUser;

    @ManyToOne
    @JoinColumn(name = USER_COMPLAIN_REPORT_COLUMN_REPORTED_ID, nullable = false, referencedColumnName = USER_COLUMN_USER_ID)
    private User reportedUser;

    @Column(name = USER_COMPLAIN_REPORT_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
}