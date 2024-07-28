package com.kampus.dataAccess;

import com.kampus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserName(String userName); //SpringJPA keywords
}
