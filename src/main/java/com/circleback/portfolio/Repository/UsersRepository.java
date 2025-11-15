package com.circleback.portfolio.Repository;

import com.circleback.portfolio.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
