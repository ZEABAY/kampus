package com.kampus.dataAccess;

import com.kampus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username); //SpringJPA keywords
}
