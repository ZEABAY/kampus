package com.kampus.service.concretes;

import com.kampus.core.config.JwtService;
import com.kampus.core.utilities.mappers.ModelMapperService;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import com.kampus.service.responses.authentication.AuthenticationResponse;
import com.kampus.service.rules.UserBusinessRules;
import com.kampus.service.rules.authentication.AuthenticationRequest;
import com.kampus.service.rules.authentication.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = this.modelMapperService.forRequest().map(registerRequest, User.class);

        userBusinessRules.encodePassword(user);

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );

        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
