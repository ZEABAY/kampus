package com.kampus.api.controllers;

import com.kampus.core.api.controllers.BaseController;
import com.kampus.service.concretes.UserService;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.authentication.AuthenticationResponse;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController<Void, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserService userService;

    @Override
    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllUsersResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    // Kullanıcıyı güncelleyen endpoint
    @PutMapping("/update")
    public ResponseEntity<AuthenticationResponse> update(@RequestBody UpdateUserRequest updateUserRequest) {
        AuthenticationResponse response = userService.update(updateUserRequest);
        return ResponseEntity.ok(response);
    }


}
