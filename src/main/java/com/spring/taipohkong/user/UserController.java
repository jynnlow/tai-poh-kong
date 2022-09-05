package com.spring.taipohkong.user;

import com.spring.taipohkong.helper.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    public final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public  Response logIn(@RequestBody UserDTO loginReq){
        return service.logIn(loginReq);
    }

//    @PostMapping
//    public  String logIn(@RequestBody UserDTO loginReq){
//        return loginReq.getUsername();
//    }

}
