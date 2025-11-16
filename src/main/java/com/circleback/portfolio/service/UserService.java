package com.circleback.portfolio.service;

import com.circleback.portfolio.Repository.UsersRepository;
import com.circleback.portfolio.entity.Users;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Users createUser(Users users){
        logger.info("ADDING NEW USER {}", users.toString());
        try {
            Users newUsers = Users.builder()
                    .firstName(users.getFirstName())
                    .lastName(users.getLastName())
                    .age(users.getAge())
                    .email(users.getEmail())
                    .password(passwordEncoder.encode(users.getPassword()))
                    .address1(users.getAddress1())
                    .address2(users.getAddress2())
                    .role(users.getRole())
                    .zip(users.getZip())
                    .build();
            logger.debug("USER SUCCESSFULLY SAVED WITH USER ID {}", users.getId());
            return usersRepository.save(newUsers);
        } catch (Exception e) {
            logger.error("FAILED TO SAVE USER WITH EMAIL {}", users.getEmail(), e);
            throw new RuntimeException(e);
        }
    }

    public Users findByEmail(String email){
        Optional<Users> userEntity = usersRepository.findByEmail(email);
        return userEntity.orElse(null);
    }

}
