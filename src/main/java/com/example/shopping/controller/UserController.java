package com.example.shopping.controller;

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
@RequestMapping("/api/v1/accounts")
public class AccountController {
    AccountService accountService;
    @PostMapping()
    public AccountDTOResponse createAccount(@RequestBody AccountDTOCreate accountDTOCreate) {
        return accountService.createAccount(accountDTOCreate);
    }
}
