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
@Table(name = CITY_TABLE)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CITY_SEQ_CITY)
    @SequenceGenerator(name = CITY_SEQ_CITY, sequenceName = CITY_SEQ_CITY_ID, allocationSize = CITY_SEQ_CITY_ID_ALLOCATION_SIZE)
    @Column(name = CITY_COLUMN_CITY_ID)
    private int cityId;

    //! EKLENDI nullable = false
    @Column(name = CITY_COLUMN_CITY_NAME, nullable = false)
    private String cityName;
}