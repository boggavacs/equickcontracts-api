package com.circleback.portfolio.entity;

@FunctionalInterface
public interface ValidateRoles {
    boolean hasRole(String role);
}
