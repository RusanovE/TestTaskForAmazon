package com.example.testtaskforamazon.controllers;

import com.example.testtaskforamazon.DTO.ErrorDTO;
import com.example.testtaskforamazon.DTO.JwtRequest;
import com.example.testtaskforamazon.DTO.JwtResponse;
import com.example.testtaskforamazon.DTO.RegistrationUserDTO;
import com.example.testtaskforamazon.services.UserService;
import com.example.testtaskforamazon.services.impl.CustomUserDetailsServiceImpl;
import com.example.testtaskforamazon.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/users")
public class AuthController {

    final CustomUserDetailsServiceImpl customUserDetailsService;

    final UserService userService;

    final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest jwtRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getLogin(), jwtRequest.getPassword()));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>( new ErrorDTO(HttpStatus.UNAUTHORIZED.value(), "Bad credential"), HttpStatus.UNAUTHORIZED);
        }
        return customUserDetailsService.authentication(jwtRequest);
    }

    @PostMapping("/regUser")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDTO registrationUserDTO){
        return userService.createNewUser(registrationUserDTO);
    }

}
