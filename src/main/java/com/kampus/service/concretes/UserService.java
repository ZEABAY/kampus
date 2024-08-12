package com.kampus.service.concretes;

import com.kampus.core.service.BaseService;
import com.kampus.core.utilities.mappers.ModelMapperService;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import com.kampus.service.requests.userRequests.CreateUserRequest;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import com.kampus.service.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService implements BaseService<CreateUserRequest, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);

        //İş kulları
        //this.userBusinessRules.checkIfUsernameExists(createUserRequest.username());


        this.userRepository.save(user);
    }

    @Override
    public GetUserByIdResponse getById(Long id) {
        User user = this.userRepository.findById(id).orElse(null);

        GetUserByIdResponse response = this.modelMapperService.forResponse()
                .map(user, GetUserByIdResponse.class);


        return response;
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetAllUsersResponse> responses = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).toList();

        return responses;
    }

    @Override
    public void update(UpdateUserRequest updateRequest) {
        User user = this.modelMapperService.forRequest().map(updateRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
