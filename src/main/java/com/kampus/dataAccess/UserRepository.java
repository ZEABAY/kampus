package com.kampus.dataAccess;

import com.kampus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUserName(String userName); //SpringJPA keywords
}
