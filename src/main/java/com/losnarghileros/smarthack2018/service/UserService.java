package com.losnarghileros.smarthack2018.service;

import com.losnarghileros.smarthack2018.entities.User;
import com.losnarghileros.smarthack2018.entities.enums.UserType;
import com.losnarghileros.smarthack2018.projections.UserRegister;
import com.losnarghileros.smarthack2018.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegister userRegister) {
        userRepository.save(
                new User(
                        userRegister.getUsername(),
                        userRegister.getEmail(),
                        UserType.USER,
                        true,
                        bCryptPasswordEncoder.encode(userRegister.getPassword()),
                        new Date(),
                        new Date(),
                        new Date()
                        ));
    }


}
