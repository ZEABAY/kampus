package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Universities")

public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universities_seq")
    @SequenceGenerator(name = "universities_seq", sequenceName = "universities_id_seq", allocationSize = 1)
    @Column(name = "university_id", nullable = false)
    private int universityID;

    @Column(name = "university_name", nullable = false)
    private String universityName;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;
}
