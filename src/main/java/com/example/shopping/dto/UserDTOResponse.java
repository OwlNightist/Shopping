package com.example.shopping.dto;

import com.example.shopping.entity.User.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTOResponse {
    int id;
    String username;
    String email;
    String role;
}
