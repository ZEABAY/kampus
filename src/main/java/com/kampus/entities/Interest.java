package com.kampus.entities;

import com.kampus.core.utilities.enums.InterestType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static com.kampus.core.constants.EntityConstants.*;

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

    @Enumerated(EnumType.STRING)
    @Column(name = INTEREST_COLUMN_INTEREST_TYPE, nullable = false)
    private InterestType interestType;

    @ManyToMany(mappedBy = INTEREST_MAP_INTERESTS, cascade = CascadeType.ALL)
    private Set<User> users;

}
