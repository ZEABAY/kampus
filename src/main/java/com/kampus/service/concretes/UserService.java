package com.kampus.service.concretes;

import com.kampus.core.config.JwtService;
import com.kampus.core.service.BaseService;
import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.core.utilities.mappers.ModelMapperService;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.authentication.AuthenticationResponse;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import com.kampus.service.rules.UserBusinessRules;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

import static com.kampus.core.handler.BusinessErrorCodes.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserService extends BaseService<Void, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public GetUserByIdResponse getById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new BusinessException(
                USER_NOT_FOUND.getCode(),
                USER_NOT_FOUND.getHttpStatus(),
                USER_NOT_FOUND.getDescription()
        ));

        return this.modelMapperService.forResponse()
                .map(user, GetUserByIdResponse.class);
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = this.userRepository.findAll();

        return users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
                .toList();
    }

    // Kullanıcıyı güncellenmiş bilgilerle güncelle
    @Override
    @Transactional
    public AuthenticationResponse update(String username, UpdateUserRequest updateRequest) {
        // Kullanıcıyı mevcut username ile bul
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new BusinessException(
                        USER_NOT_FOUND.getCode(),
                        USER_NOT_FOUND.getHttpStatus(),
                        USER_NOT_FOUND.getDescription()
                ));

        // İş kurallarını kontrol et
        userBusinessRules.checkIfUsernameExists(updateRequest.getUsername());
        userBusinessRules.checkIfMailExists(updateRequest.getEmail());
        userBusinessRules.checkIfPhoneNumberExists(updateRequest.getPhoneNumber());

        // Güncellenmiş alanları ayarla
        updateUserField(user::setUsername, updateRequest.getUsername());
        updateUserField(user::setEmail, updateRequest.getEmail());
        if (updateRequest.getPassword() != null) {
            updateUserField(user::setPassword, passwordEncoder.encode(updateRequest.getPassword()));
        }
        updateUserField(user::setFirstName, updateRequest.getFirstName());
        updateUserField(user::setLastName, updateRequest.getLastName());
        updateUserField(user::setPhoneNumber, updateRequest.getPhoneNumber());

        // Güncellenmiş kullanıcıyı veritabanına kaydet
        this.userRepository.save(user);

        // Yeni JWT token oluştur
        String newJwtToken = jwtService.generateToken(user);

        // Yanıtı döndür
        return AuthenticationResponse.builder().token(newJwtToken).build();
    }


    @Override
    public void delete(Long id) {
        if (!this.userRepository.existsById(id)) {
            throw new BusinessException(
                    USER_NOT_FOUND.getCode(),
                    USER_NOT_FOUND.getHttpStatus(),
                    USER_NOT_FOUND.getDescription()
            );
        }
        this.userRepository.deleteById(id);
    }


    private void updateUserField(Consumer<String> setter, String value) {
        if (value != null && !value.isEmpty()) {
            setter.accept(value);
        }
    }
}
