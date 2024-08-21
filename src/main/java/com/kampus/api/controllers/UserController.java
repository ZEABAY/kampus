package com.kampus.api.controllers;

import com.kampus.core.api.controllers.BaseController;
import com.kampus.service.concretes.UserService;
import com.kampus.service.requests.userRequests.UpdateUserRequest;
import com.kampus.service.responses.authentication.AuthenticationResponse;
import com.kampus.service.responses.userResponses.GetAllUsersResponse;
import com.kampus.service.responses.userResponses.GetUserByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController<Void, Long, GetUserByIdResponse, GetAllUsersResponse, UpdateUserRequest> {
    private final UserService userService;

    @Override
    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllUsersResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<AuthenticationResponse> update(
            @RequestBody UpdateUserRequest updateUserRequest
    ) {

        // isteği atan kullanıcı
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        AuthenticationResponse response = userService.update(username, updateUserRequest);
        return ResponseEntity.ok(response);
    }


}
