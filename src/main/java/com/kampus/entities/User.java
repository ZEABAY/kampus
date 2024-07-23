package com.kampus.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
N
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_seq",sequenceName = "user_id_seq",allocationSize = 1)
    @Column(name = "user_id",unique = true,nullable = false)
    private Long userId;

    @Column(name="user_name",nullable = false)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name="mail",nullable = false)
    private String mail;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(name="birth_date")
    private LocalDate birthDate;
    // dd.MM.yyyy

    @Column(name = "biography")
    private String biography;

    @Column(name = "profile_pic_url")
    private String profilePicUrl;

    @Column (name = "avatar_url")
    private String avatarUrl;

    @Column(name = "roles",nullable = false)
    private String roles;


    @ManyToOne
    @JoinColumn(name="university_id")
    private Universities university;

    @ManyToOne
    @JoinColumn(name="major_id")
    private Majors major;
    // burda userinterest tablosunu spring üzerinden oluşturduk db ye gerek kalmadı
    // kartezyen tablo gibi manytomany bir kullanıcı birden fazla hobiye sahip olabilir
    // bir hobide birden fazla kullanıcı tarafından  kullanılabilir.
    @ManyToMany
    @JoinTable(
            name = "UserInterests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interests> interests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostLikes> postLikes = new HashSet<>();

    @Column(name = "permissions")
    private String permissions;

    @Column(name= "is_private")
    private Boolean isPrivate;

    @Column(name = "created_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name="current_situation")
    private String currentSituation;

    @Column(name = "status",nullable = false)
    private String status;


}
