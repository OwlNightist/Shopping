package com.example.shopping.controller;

import com.example.shopping.dto.UserDTOCreate;
import com.example.shopping.dto.UserDTOResponse;
import com.example.shopping.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    UserService userService;
    @PostMapping()
    public UserDTOResponse createUser(@RequestBody UserDTOCreate userDTOCreate) {
        return userService.createUser(userDTOCreate);
    }
}
