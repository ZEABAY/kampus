package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Majors")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "majors_seq")
    @SequenceGenerator(name = "majors_seq", sequenceName = "majors_id_seq", allocationSize = 1)
    @Column(name = "major_id", unique = true, nullable = false)
    private int majorId;

    @Column(name = "major_name")
    private String majorName;

}
