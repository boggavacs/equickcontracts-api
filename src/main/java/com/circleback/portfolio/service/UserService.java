package com.circleback.portfolio.service;

import com.circleback.portfolio.Repository.UsersRepository;
import com.circleback.portfolio.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserEntity createUser(UserEntity userEntity){
        logger.info("ADDING NEW USER {}", userEntity.toString());
        try {
            UserEntity newUserEntity = UserEntity.builder()
                    .firstName(userEntity.getFirstName())
                    .lastName(userEntity.getLastName())
                    .age(userEntity.getAge())
                    .email(userEntity.getEmail())
                    .password(passwordEncoder.encode(userEntity.getPassword()))
                    .address1(userEntity.getAddress1())
                    .address2(userEntity.getAddress2())
                    .role(userEntity.getRole())
                    .zip(userEntity.getZip())
                    .build();
            logger.debug("USER SUCCESSFULLY SAVED WITH USER ID {}", userEntity.getId());
            return usersRepository.save(newUserEntity);
        } catch (Exception e) {
            logger.error("FAILED TO SAVE USER WITH EMAIL {}", userEntity.getEmail(), e);
            throw new RuntimeException(e);
        }
    }

    public UserEntity findByEmail(String email){
        Optional<UserEntity> userEntity = usersRepository.findByEmail(email);
        return userEntity.orElse(null);
    }

}
