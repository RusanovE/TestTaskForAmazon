package com.example.testtaskforamazon.services.impl;

import com.example.testtaskforamazon.DTO.ErrorDTO;
import com.example.testtaskforamazon.DTO.JwtRequest;
import com.example.testtaskforamazon.DTO.JwtResponse;
import com.example.testtaskforamazon.entities.UserEntity;
import com.example.testtaskforamazon.repositories.UserRepository;
import com.example.testtaskforamazon.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    final JwtTokenUtils tokenUtils;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User %s not found", username)
        ));
        return new User(user.getLogin()
                , user.getPassword()
                , Collections.singleton(new SimpleGrantedAuthority(user.getRole().name())));
    }

    public ResponseEntity<?> authentication(JwtRequest jwtRequest){
        String token;
        try {
            UserDetails userDetails = loadUserByUsername(jwtRequest.getLogin());
            token = tokenUtils.generateToken(userDetails);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>( new ErrorDTO(HttpStatus.UNAUTHORIZED.value(), "Bad credential"), HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
