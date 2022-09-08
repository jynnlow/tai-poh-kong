package com.spring.taipohkong.service;

import com.spring.taipohkong.dto.UserDTO;
import com.spring.taipohkong.helper.Response;

public interface UserService {
    void logIn(UserDTO loginReq) throws Exception;
    Response logout();
}
