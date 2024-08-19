package com.kampus.service.rules;

import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.kampus.core.handler.BusinessErrorCodes.*;

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

    public void checkIfMailExists(String email) {
        if (this.userRepository.existsByEmail(email)) {
            throw new BusinessException(
                    EMAIL_ALREADY_EXISTS.getCode(),
                    EMAIL_ALREADY_EXISTS.getHttpStatus(),
                    EMAIL_ALREADY_EXISTS.getDescription()
            );
        }
    }

    public void checkIfPhoneNumberExists(String phoneNumber) {
        if (this.userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new BusinessException(
                    PHONE_NUMBER_ALREADY_EXISTS.getCode(),
                    PHONE_NUMBER_ALREADY_EXISTS.getHttpStatus(),
                    PHONE_NUMBER_ALREADY_EXISTS.getDescription()
            );
        }
    }

    public void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
