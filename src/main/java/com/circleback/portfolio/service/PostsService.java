package com.circleback.portfolio.service;

import com.circleback.portfolio.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.posts.url}")
    private String postsUrl;

    public List<Posts> getPosts(){

        ResponseEntity<List<Posts>> posts = restTemplate.exchange(
                postsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Posts>>() {
                }
        );
        return posts.getBody();
    }
}
