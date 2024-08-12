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
@Table(name = USER_VERIFICATION_TABLE)
public class UserVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = USER_VERIFICATION_SEQ_USER_VERIFICATION, sequenceName = USER_VERIFICATION_SEQ_USER_VERIFICATION_ID, allocationSize = USER_VERIFICATION_SEQ_USER_VERIFICATION_ID_ALLOCATION_SIZE)
    @Column(name = USER_VERIFICATION_COLUMN_VERIFICATION_ID)
    private Long verificationId;

    @ManyToOne
    @JoinColumn(name = USER_COLUMN_USER_ID, referencedColumnName = USER_COLUMN_USER_ID)
    private User user;

    @Column(name = USER_VERIFICATION_COLUMN_VERIFICATION_CODE, nullable = false)
    private String verificationCode;

    @Column(name = USER_VERIFICATION_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = USER_VERIFICATION_COLUMN_HAVE_USED, nullable = false)
    private Boolean haveUsed;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.haveUsed = false;
    }
}
