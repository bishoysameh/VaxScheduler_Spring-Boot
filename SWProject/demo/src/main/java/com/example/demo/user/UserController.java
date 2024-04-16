package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/User")



public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
      return userService.getAllUsers();
    }

    @GetMapping(path = "{UserId}")
    public User getOneUser(@PathVariable("UserId") int id){
        return userService.getOneUser(id);
    }

    //function to get patients which waiting to approve by admin
    @GetMapping("/Patients")
    public List<User> getAllPatients(){
        return userService.getAllPatients();
      }

}
