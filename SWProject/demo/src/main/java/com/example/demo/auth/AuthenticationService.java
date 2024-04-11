package com.example.demo.auth;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
// import com.example.demo.user.Role;
import com.example.demo.user.UserRepositry;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
 private final PasswordEncoder passwordEncoder; 
 private final UserRepositry repository;
 private final JwtService jwtService;
 private final AuthenticationManager authenticationManager;

    @SuppressWarnings("null")
    public AuthenticationResponse register(RegisterRequest request) {

   var user = com.example.demo.user.User.builder()
     .firstName(request.getFirstname())
     .lastName(request.getLastname())
     .email(request.getEmail())
     .password(passwordEncoder.encode(request.getPassword()))
     .role(request.getRole())
     .build();
         repository.save(user);
     var jwtToken = jwtService.generateToken(user);
     return AuthenticationResponse.builder().token(jwtToken).build();
    }


    
    public AuthenticationResponse authenticate(authenticationRequest request) {
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken (
          request.getEmail(),
          request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();

    }



}
