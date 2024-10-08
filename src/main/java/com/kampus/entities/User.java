package com.kampus.entities;


import com.kampus.core.utilities.enums.UserRoles;
import com.kampus.core.utilities.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static com.kampus.core.constants.EntityConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = USER_TABLE, indexes = {
        @Index(name = USER_IDX_USER_MAIL, columnList = USER_COLUMN_MAIL, unique = true),
        @Index(name = USER_IDX_USER_USERNAME, columnList = USER_COLUMN_USERNAME, unique = true)}

)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_SEQ_USER)
    @SequenceGenerator(name = USER_SEQ_USER, sequenceName = USER_SEQ_USER_ID, allocationSize = USER_SEQ_USER_ID_ALLOCATION_SIZE)
    @Column(name = USER_COLUMN_USER_ID, unique = true, nullable = false)
    private Long userId;

    @Column(name = USER_COLUMN_USERNAME, nullable = false)
    private String username;

    @Column(name = USER_COLUMN_PASSWORD, nullable = false)
    private String password;

    @Column(name = USER_COLUMN_MAIL, nullable = false)
    private String email;

    @Column(name = USER_COLUMN_FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = USER_COLUMN_LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = USER_COLUMN_PHONE_NUMBER, unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = USER_COLUMN_BIRTH_DATE)
    private LocalDate birthDate;
    // dd.MM.yyyy

    @Column(name = USER_COLUMN_BIOGRAPHY)
    private String biography;

    @Column(name = USER_COLUMN_PROFILE_PIC_URL)
    private String profilePicUrl;

    @Column(name = USER_COLUMN_AVATAR_URL)
    private String avatarUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = USER_COLUMN_ROLE, nullable = false)
    private UserRoles role;

    @Column(name = USER_COLUMN_IS_PRIVATE, nullable = false)
    private Boolean isPrivate;

    @Column(name = USER_COLUMN_CREATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = USER_COLUMN_UPDATED_AT, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    @Column(name = USER_COLUMN_CURRENT_SITUATION)
    private String currentSituation;

    @Enumerated(EnumType.STRING)
    @Column(name = USER_COLUMN_STATUS, nullable = false)
    private UserStatus status;

    @ManyToOne
    @JoinColumn(name = UNIVERSITY_COLUMN_UNIVERSITY_ID)
    private University university;

    @ManyToOne
    @JoinColumn(name = MAJOR_COLUMN_MAJOR_ID, referencedColumnName = MAJOR_COLUMN_MAJOR_ID)
    private Major major;

    @ManyToMany
    @JoinTable(
            name = USER_INTEREST_TABLE,
            joinColumns = @JoinColumn(name = USER_COLUMN_USER_ID),
            inverseJoinColumns = @JoinColumn(name = INTEREST_COLUMN_INTEREST_ID)
    )
    private Set<Interest> interests;

    @OneToMany(mappedBy = USER_MAP_USER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommunityMember> communityMemberships;

    @OneToMany(mappedBy = USER_MAP_USER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostLike> postLikes;


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.role = UserRoles.USER;
        this.status = UserStatus.INACTIVE;
        this.isPrivate = false;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
