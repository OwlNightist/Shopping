package com.example.shopping.service;

import com.example.shopping.dto.LoginDTORequest;
import com.example.shopping.dto.LoginDTOResponse;
import com.example.shopping.dto.UserDTOCreate;
import com.example.shopping.dto.UserDTOResponse;

public interface UserService {

    UserDTOResponse createUser(UserDTOCreate userDTOCreate);

    LoginDTOResponse login(LoginDTORequest loginDTORequest);
}
