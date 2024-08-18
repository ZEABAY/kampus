package com.kampus.entities;

import com.kampus.core.utilities.enums.ReportType;
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
@Table(name = USER_COMPLAIN_REPORT_TABLE, indexes = {
        @Index(name = USER_COMPLAIN_REPORT_IDX_REPORTER_USER, columnList = USER_COMPLAIN_REPORT_COLUMN_REPORTER_ID),
        @Index(name = USER_COMPLAIN_REPORT_IDX_REPORTED_USER, columnList = USER_COMPLAIN_REPORT_COLUMN_REPORTED_ID),
        @Index(name = USER_COMPLAIN_REPORT_IDX_CREATED_AT, columnList = USER_COMPLAIN_REPORT_COLUMN_CREATED_AT)
})
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
    @JoinColumn(name = USER_COMPLAIN_REPORT_COLUMN_REPORTER_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User reporterUser;

    @ManyToOne
    @JoinColumn(name = USER_COMPLAIN_REPORT_COLUMN_REPORTED_ID, referencedColumnName = USER_COLUMN_USER_ID, nullable = false)
    private User reportedUser;

    @Column(name = USER_COMPLAIN_REPORT_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
}