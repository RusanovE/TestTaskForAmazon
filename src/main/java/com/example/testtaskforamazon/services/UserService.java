package com.example.testtaskforamazon.services;

import com.example.testtaskforamazon.DTO.RegistrationUserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> createNewUser(RegistrationUserDTO registrationUserDTO);

}
