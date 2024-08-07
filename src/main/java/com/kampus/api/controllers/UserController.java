package com.kampus.api.controllers;

import com.kampus.core.api.controllers.BaseController;
import com.kampus.service.concretes.UserService;
import com.kampus.service.requests.userRequests.CreateUserRequest;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController implements BaseController<CreateUserRequest, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserService userService;

    @Override
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody() @Valid() CreateUserRequest createUserRequest) {
        userService.add(createUserRequest);
    }

    @Override
    @GetMapping("/{id}")
    public GetUserByIdResponse getById(@PathVariable() Long id) {
        return null;
    }

    @Override
    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }

    @Override
    @PutMapping("/update")
    public void update(@RequestBody() UpdateUserRequest updateUserRequest) {
    }

    @Override
    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
    }
}
