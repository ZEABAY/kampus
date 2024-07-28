package com.kampus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Interests")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "interest_seq")
    @SequenceGenerator(name = "ınterests_seq", sequenceName = "interests_id_seq", allocationSize = 1)
    @Column(name = "interest_id",nullable = false,unique = true)
    private int interestId;

    @Column(name = "interest_name")
    private String interestName;

    @Column(name = "interest_type")
    private String interestType;

    @ManyToMany(mappedBy = "interests")
    private Set<User> users;

}
