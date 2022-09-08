package com.spring.taipohkong.service;

import com.spring.taipohkong.dto.UserDTO;
import com.spring.taipohkong.helper.Response;
import com.spring.taipohkong.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService{
    public final UserRepo repository;

    @Override
    public void logIn(UserDTO loginReq) throws Exception {
        //validation 1 - check if either username and password is empty
        if (loginReq.getUsername().isEmpty() || loginReq.getPassword().isEmpty()){
            throw new Exception("Please fill in both username and password");
        }

        Optional<String> dbPasswordOptional = repository.findPasswordByUsername(loginReq.getUsername());
        String dbPassword = dbPasswordOptional.orElse("");

        //validation 2 - check if user found in db
        if (dbPassword.isEmpty()){
            throw new Exception("No user found");
        }

        //validation 3 - check if password is correct
        if (!loginReq.getPassword().equals(dbPassword)){
            throw new Exception("Invalid Password");
        }
    }

    @Override
    public Response logout() {
        return null;
    }
}

