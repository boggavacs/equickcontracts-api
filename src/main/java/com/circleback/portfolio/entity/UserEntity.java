package com.circleback.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "Users")
public class UserEntity implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    private String Id;

    private String firstName;
    private String lastName;
    private int age;
    private String address1;
    private String address2;
    private String zip;
    private String email;
    private String password;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return org.springframework.security.core.userdetails.UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return org.springframework.security.core.userdetails.UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return org.springframework.security.core.userdetails.UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return org.springframework.security.core.userdetails.UserDetails.super.isEnabled();
    }
}
