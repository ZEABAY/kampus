package com.kampus.service.concretes;

import com.kampus.core.service.BaseService;
import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.core.utilities.mappers.ModelMapperService;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import com.kampus.service.requests.userRequests.CreateUserRequest;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import com.kampus.service.rules.UserBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kampus.core.handler.BusinessErrorCodes.NO_CODE;
import static com.kampus.core.handler.BusinessErrorCodes.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UserService implements BaseService<CreateUserRequest, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;

    @Override
    public void add(CreateUserRequest createUserRequest) {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }

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
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).toList();
    }

    @Override
    public void update(UpdateUserRequest updateRequest) {
        userBusinessRules.checkIfUserExist(updateRequest.getUserId());

        User user = this.modelMapperService.forRequest().map(updateRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
