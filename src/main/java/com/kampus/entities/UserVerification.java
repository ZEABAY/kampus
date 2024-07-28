package com.kampus.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserVerification")
public class UserVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "userverification_seq",sequenceName = "userverification_id_seq")
    @Column(name = "verification_id")
    private Long verificationId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @Column(name = "verification_code",nullable = false)
    private String verificationCode;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();


    @Column(name = "have_used",nullable = false)
    private Boolean haveUsed = false;
}
