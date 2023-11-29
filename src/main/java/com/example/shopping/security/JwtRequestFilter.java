package com.example.shopping.security;

import com.example.shopping.entity.User.User;
import com.example.shopping.mapper.UserMapper;
import com.example.shopping.model.TokenPayload;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtRequestFilter extends OncePerRequestFilter {
    JwtTokenUtil jwtTokenUtil;
    UserRepository userRepository;
    UserMapper userMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String token = null;
        TokenPayload tokenPayLoad = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            token = requestTokenHeader.split(" ")[1];

            try {
                tokenPayLoad = jwtTokenUtil.getTokenPayload(token);
            } catch (IllegalArgumentException ex) {
                System.out.println("Unable to get JWT");
            } catch (ExpiredJwtException ex) {
                System.out.println("Token has expired");
            }
        } else {
            System.out.println("JWT Token does not start with 'Bearer '");
        }

        if (tokenPayLoad != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Optional<User> userOptional = userRepository.findById(tokenPayLoad.getAccountId());

            if (userOptional.isPresent()) {
                User user = userOptional.get();

                // check token co hop le hay ko
                if (jwtTokenUtil.isValid(token, userMapper.toTokenPayload(user))) {

                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                            user
                                    .getPassword(), authorities);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, authorities);

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);

    }

}
