package com.example.testtaskforamazon.services.impl;

import com.example.testtaskforamazon.DTO.ErrorDTO;
import com.example.testtaskforamazon.DTO.RegistrationUserDTO;
import com.example.testtaskforamazon.entities.Role;
import com.example.testtaskforamazon.entities.UserEntity;
import com.example.testtaskforamazon.repositories.UserRepository;
import com.example.testtaskforamazon.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> createNewUser(RegistrationUserDTO registrationUserDTO){
        if (userRepository.findByLogin(registrationUserDTO.getLogin()).isPresent()) {
            return new ResponseEntity<>(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        try {
         UserEntity userEntity = new UserEntity(registrationUserDTO.getLogin(), passwordEncoder.encode(registrationUserDTO.getPassword()));
         userEntity.setRole(Role.ROLE_USER);
         userRepository.save(userEntity);
        } catch (Exception e) {
            return new ResponseEntity<>( new ErrorDTO(HttpStatus.BAD_REQUEST.value(), "Bad request"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("new User Add");

    }

}
