package com.spring.taipohkong.user;

import com.spring.taipohkong.helper.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    public final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Response logIn(UserDTO loginReq){
        //check for empty username and password
        if (loginReq.getUsername().isEmpty() || loginReq.getPassword().isEmpty()){
           return new Response("FAILED","Please fill in both username and password");
        }
        Optional<User> dbUser = repository.findPasswordByUsername(loginReq.getUsername());
        if (dbUser.isPresent()){
            return new Response("FAILED","Incorrect password. Please try again.");
        }
        return new Response("SUCCESS","Login successfully");
    }
}
