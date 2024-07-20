package com.kampus.service.concretes;

import com.kampus.core.service.BaseService;
import com.kampus.core.utilities.mappers.ModelMapperService;
import com.kampus.dataAccess.UserRepository;
import com.kampus.service.requests.CreateUserRequest;
import com.kampus.service.requests.UpdateUserRequest;
import com.kampus.service.responses.GetAllUsersByIdResponse;
import com.kampus.service.responses.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/**
 * Zeynel Abiddin Aydar 20/07/2024
 * */
@Service
@AllArgsConstructor
public class UserService implements BaseService<CreateUserRequest, UUID, GetUserByIdResponse, GetAllUsersByIdResponse, UpdateUserRequest> {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(CreateUserRequest createUserRequest) {

    }

    @Override
    public GetUserByIdResponse getById(UUID id) {
        return null;
    }

    @Override
    public List<GetAllUsersByIdResponse> getAll() {
        return List.of();
    }

    @Override
    public void update(UpdateUserRequest updateRequest) {

    }

    @Override
    public void delete(UUID id) {

    }
}
