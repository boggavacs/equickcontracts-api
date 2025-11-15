package com.circleback.portfolio.controller;

import com.circleback.portfolio.entity.UserEntity;
import com.circleback.portfolio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class Users {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity newUserEntity = userService.createUser(userEntity);
        return ResponseEntity.ok(newUserEntity);
    }
}
