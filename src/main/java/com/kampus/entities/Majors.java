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
public class Majors {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "majors_seq", sequenceName = "majors_id_seq", allocationSize = 1)
    @Column(name = "major_id")
    private int majorId;

    @Column(name = "major_name")
    private String majorName;

}
