package com.circleback.portfolio.entity.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentityDetails {
//    private String id;
    private String name;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
}
