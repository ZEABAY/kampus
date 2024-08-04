package com.kampus.service.rules;

import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.dataAccess.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kampus.core.constants.ExceptionConstants.EXCEPTION_CONSTANT_USERNAME_EXIST;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private final UserRepository userRepository;

    public void checkIfUsernameExists(String username) {
        if (this.userRepository.existsByUsername(username)) {
            throw new BusinessException(EXCEPTION_CONSTANT_USERNAME_EXIST);
        }
    }
}
