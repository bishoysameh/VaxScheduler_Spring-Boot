package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepositry extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    List<User> findByStatus(String status);
    

}
