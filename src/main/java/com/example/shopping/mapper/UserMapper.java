package com.example.shopping.mapper;


import com.example.shopping.dto.UserDTOCreate;
import com.example.shopping.dto.UserDTOResponse;
import com.example.shopping.entity.User.Role;
import com.example.shopping.entity.User.User;
import com.example.shopping.entity.User.UserRoles;
import com.example.shopping.model.TokenPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "accountId", source = "id")
    TokenPayload toTokenPayload(User user);

    User toUser(UserDTOCreate userDTOCreate);
    @Mapping(target = "role", source = "user.userRoles.role.name")
     UserDTOResponse toUserDTOResponse(User user);

}
