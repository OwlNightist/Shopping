package com.example.shopping.controller;

import com.example.shopping.dto.LoginDTORequest;
import com.example.shopping.dto.LoginDTOResponse;
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
@RequestMapping("/api/v1")
public class AuthenticationController {
    UserService userService;
    @PostMapping("/login")
    public LoginDTOResponse login(@RequestBody LoginDTORequest loginDTORequest) {
        return userService.login(loginDTORequest);
    }
}
