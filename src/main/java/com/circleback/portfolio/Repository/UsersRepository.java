package com.circleback.portfolio.Repository;

import com.circleback.portfolio.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
