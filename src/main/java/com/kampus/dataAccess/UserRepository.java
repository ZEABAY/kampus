package com.kampus.dataAccess;

import com.kampus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


/**
 * Zeynel Abiddin Aydar 20/07/2024
 * */
public interface UserRepository extends JpaRepository<User, UUID> {
}
