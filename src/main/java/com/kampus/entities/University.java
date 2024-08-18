package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = UNIVERSITY_TABLE)

public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = UNIVERSITY_SEQ_UNIVERSITY)
    @SequenceGenerator(name = UNIVERSITY_SEQ_UNIVERSITY, sequenceName = UNIVERSITY_SEQ_UNIVERSITY_ID, allocationSize = UNIVERSITY_SEQ_UNIVERSITY_ID_ALLOCATION_SIZE)
    @Column(name = UNIVERSITY_COLUMN_UNIVERSITY_ID, nullable = false)
    private int universityId;

    @Column(name = UNIVERSITY_COLUMN_UNIVERSITY_NAME, nullable = false, unique = true)
    private String universityName;

    @ManyToOne
    @JoinColumn(name = CITY_COLUMN_CITY_ID, referencedColumnName = CITY_COLUMN_CITY_ID, nullable = false)
    private City city;
}