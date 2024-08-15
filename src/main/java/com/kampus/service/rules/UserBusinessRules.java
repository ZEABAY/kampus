package com.kampus.service.rules;

import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.kampus.core.handler.BusinessErrorCodes.USERNAME_ALREADY_EXISTS;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void checkIfUsernameExists(String username) {
        if (this.userRepository.existsByUsername(username)) {
            throw new BusinessException(
                    USERNAME_ALREADY_EXISTS.getCode(),
                    USERNAME_ALREADY_EXISTS.getHttpStatus(),
                    USERNAME_ALREADY_EXISTS.getDescription()
            );
        }
    }

    public void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
