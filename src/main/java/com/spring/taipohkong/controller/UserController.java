package com.spring.taipohkong.controller;

import com.spring.taipohkong.dto.UserDTO;
import com.spring.taipohkong.helper.Response;
import com.spring.taipohkong.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    public final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> logIn(@RequestBody UserDTO loginReq){
        try {
            userService.logIn(loginReq);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
