package com.kampus.service.concretes;


import com.kampus.core.security.JwtService;
import com.kampus.core.utilities.mappers.ModelMapperService;
import com.kampus.dataAccess.UserRepository;
import com.kampus.entities.User;
import com.kampus.service.requests.authRequests.AuthenticationRequest;
import com.kampus.service.requests.authRequests.RegisterRequest;
import com.kampus.service.responses.authResponses.AuthenticationResponse;
import com.kampus.service.rules.UserBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
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
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        ); //hatalıysa exception firlatır

        //User giriş yaptı
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}