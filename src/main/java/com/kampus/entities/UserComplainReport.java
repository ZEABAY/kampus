package com.kampus.entities;

import com.kampus.core.utilities.enums.ReportType;
import com.kampus.core.utilities.enums.Reportable;
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
    private Reportable reportableType;

    @Column(name = USER_COMPLAIN_REPORT_COLUMN_REPORTABLE_ID, nullable = false)
    private Long reportableId;

    @Enumerated(EnumType.STRING)
    @Column(name = USER_COMPLAIN_REPORT_COLUMN_REPORTED_CONTENT, nullable = false)
    private ReportType reportedContent;

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
