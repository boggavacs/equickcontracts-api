package com.circleback.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Posts {
    private String userId;
//    private String id;
    private String title;
    private String body;

}
