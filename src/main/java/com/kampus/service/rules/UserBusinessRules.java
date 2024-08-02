package com.kampus.service.rules;

//İş Kuralları buraya yazılacak serviste kullanılacak

import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.dataAccess.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private final UserRepository userRepository;

    public void checkIfUsernameExists(String username) {
        if (this.userRepository.existsByUsername(username)) {
            throw new BusinessException("This username is already taken");
        }
    }
}
