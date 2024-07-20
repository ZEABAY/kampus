package com.kampus.api.controllers;

import com.kampus.core.api.controllers.BaseController;
import com.kampus.service.concretes.UserService;
import com.kampus.service.requests.CreateUserRequest;
import com.kampus.service.requests.UpdateUserRequest;
import com.kampus.service.responses.GetAllUsersByIdResponse;
import com.kampus.service.responses.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController implements BaseController<CreateUserRequest, UUID, GetUserByIdResponse, GetAllUsersByIdResponse, UpdateUserRequest> {
    private final UserService brandService;

    @Override
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(CreateUserRequest createUserRequest) {

    }

    @Override
    @GetMapping("/{id}")
    public GetUserByIdResponse getById(@PathVariable UUID id) {
        return null;
    }

    @Override
    @GetMapping("/getALl")
    public List<GetAllUsersByIdResponse> getAll() {
        return List.of();
    }

    @Override
    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequest updateUserRequest) {
    }

    @Override
    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
    }
}
