package com.kampus.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="cities_seq",sequenceName = "cities_id_seq",allocationSize = 1)
    @Column(name = "city_id")
    private int cityId;

    @Column(name ="city_name")
    private String cityName;


}
