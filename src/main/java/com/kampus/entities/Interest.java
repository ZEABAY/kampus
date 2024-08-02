package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static com.kampus.core.constants.entityConstants.InterestConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = INTEREST_TABLE)
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = INTEREST_SEQ_INTEREST)
    @SequenceGenerator(name = INTEREST_SEQ_INTEREST, sequenceName = INTEREST_SEQ_INTEREST_ID, allocationSize = INTEREST_SEQ_INTEREST_ID_ALLOCATION_SIZE)
    @Column(name = INTEREST_COLUMN_INTEREST_ID, nullable = false, unique = true)
    private int interestId;

    @Column(name = INTEREST_COLUMN_INTEREST_NAME)
    private String interestName;

    @Column(name = INTEREST_COLUMN_INTEREST_TYPE)
    private String interestType;

    @ManyToMany(mappedBy = INTEREST_MAP_INTERESTS)
    private Set<User> users;

}
