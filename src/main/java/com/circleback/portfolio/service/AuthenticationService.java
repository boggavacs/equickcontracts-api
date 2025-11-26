package com.circleback.portfolio.service;

import com.circleback.portfolio.Configuration.JwtService;
import com.circleback.portfolio.Repository.UsersRepository;
import com.circleback.portfolio.entity.AuthenticateRequest;
import com.circleback.portfolio.entity.AuthenticationResponse;
import com.circleback.portfolio.entity.Role;
import com.circleback.portfolio.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Users.userResponse registerUser(Users request) {
        Users user = usersRepository.findByEmail(request.getEmail()).orElse(null);
        if(user != null){
            return Users.userResponse.builder()
                    .message("User with email " + request.getEmail() + " already exists")
                    .build();
        }else {
            user = Users.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .age(request.getAge())
                    .address1(request.getAddress1())
                    .address2(request.getAddress2())
                    .zip(request.getZip())
                    .role(request.getRole())
                    .build();
            usersRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return Users.userResponse.builder()
                    .message("User registered successfully. ID: {}" +  user.getId())
                    .build();
        }
    }

    public AuthenticationResponse authenticate(AuthenticateRequest authenticate) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticate.getEmail(),
                        authenticate.getPassword()
                )
        );
        var user = usersRepository.findByEmail(authenticate.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
