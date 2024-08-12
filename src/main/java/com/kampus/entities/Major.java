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
@Table(name = MAJOR_TABLE)
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = MAJOR_SEQ_MAJOR)
    @SequenceGenerator(name = MAJOR_SEQ_MAJOR, sequenceName = MAJOR_SEQ_MAJOR_ID, allocationSize = MAJOR_SEQ_MAJOR_ID_ALLOCATION_SIZE)
    @Column(name = MAJOR_COLUMN_MAJOR_ID, unique = true, nullable = false)
    private int majorId;

    @Column(name = MAJOR_COLUMN_MAJOR_NAME, unique = true, nullable = false)
    private String majorName;

}
