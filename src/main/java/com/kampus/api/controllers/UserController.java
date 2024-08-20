package com.kampus.api.controllers;

import com.kampus.core.api.controllers.BaseController;
import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.service.concretes.UserService;
import com.kampus.service.requests.userRequests.CreateUserRequest;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kampus.core.handler.BusinessErrorCodes.NO_CODE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController implements BaseController<CreateUserRequest, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserService userService;

    @Override
    public void create(CreateUserRequest createUserRequest) {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }

    @Override
    @GetMapping("/{id}")
    public GetUserByIdResponse getById(@PathVariable() Long id) {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }

    @Override
    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }

    @Override
    @PutMapping("/update")
    public void update(@RequestBody() UpdateUserRequest updateUserRequest) {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }

    @Override
    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }
}
