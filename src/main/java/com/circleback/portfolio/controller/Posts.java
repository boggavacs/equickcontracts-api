package com.circleback.portfolio.controller;

import com.circleback.portfolio.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class Posts {

    private PostsService postsService;

    @GetMapping("/posts")
    public ResponseEntity<List<com.circleback.portfolio.entity.Posts>> getPosts(){
        return ResponseEntity.ok(postsService.getPosts());
    }
}
