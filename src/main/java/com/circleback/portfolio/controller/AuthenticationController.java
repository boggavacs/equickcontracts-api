package com.circleback.portfolio.controller;

import com.circleback.portfolio.entity.AuthenticateRequest;
import com.circleback.portfolio.entity.AuthenticationResponse;
import com.circleback.portfolio.entity.Users;
import com.circleback.portfolio.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Users.userResponse> registerUser(@RequestBody Users request) {
        return ResponseEntity.ok(authenticationService.registerUser(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody AuthenticateRequest authenticate
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticate));
    }
}
