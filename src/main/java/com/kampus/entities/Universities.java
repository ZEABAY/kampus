package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * Furkan Ayhan Gülekoğlu 20/07/2024
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Universities")

public class Universities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "universities_seq",sequenceName = "universities_id_seq", allocationSize = 1)
    @Column(name = "university_id",nullable = false)
    private int universityID;

    @Column(name="university_name",nullable = false)
    private String universityName;

    @ManyToOne
    @JoinColumn(name="city_id")
    private Cities city;
}
