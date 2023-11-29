package com.example.shopping.service.impl;

import com.example.shopping.dto.LoginDTORequest;
import com.example.shopping.dto.LoginDTOResponse;
import com.example.shopping.dto.UserDTOCreate;
import com.example.shopping.dto.UserDTOResponse;
import com.example.shopping.entity.User.Role;
import com.example.shopping.entity.User.User;
import com.example.shopping.entity.User.UserRoles;
import com.example.shopping.exception.ShopException;
import com.example.shopping.mapper.UserMapper;
import com.example.shopping.repository.RoleRepository;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.UserService;
import com.example.shopping.util.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenUtil jwtTokenUtil;
    UserMapper userMapper;
    RoleRepository roleRepository;
    @Override
    public UserDTOResponse createUser(UserDTOCreate userDTOCreate) {
        User user = userMapper.toUser(userDTOCreate);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role defaultRole = roleRepository.findRoleByName("user");
        UserRoles userRoles = UserRoles.builder().user(user).role(defaultRole).build();
        user.setUserRoles(userRoles);

        user = userRepository.save(user);
        return userMapper.toUserDTOResponse(user);
    }

    @Override
    public LoginDTOResponse login(LoginDTORequest loginDTORequest) {
        User user = userRepository.findByUsername(loginDTORequest.getUsername())
                .orElseThrow(()-> ShopException.badRequest("Account not found"));
        boolean isAuthentication =passwordEncoder.matches(loginDTORequest.getPassword(),user.getPassword());
        if (!isAuthentication) {
            throw new RuntimeException("Username or password is incorrect");
        }

        final int ONE_DAY = 24*60*60;
        String accessToken = jwtTokenUtil.generateToken(userMapper.toTokenPayload(user),ONE_DAY);

        return LoginDTOResponse.builder()
                .account(userMapper.toUserDTOResponse(user))
                .accessToken(accessToken)
                .build();
    }

}
