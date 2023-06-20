package com.ro.springbootmicroservice3apigateway.security.JWT;

import com.ro.springbootmicroservice3apigateway.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {

    String generateToken(UserPrincipal auth);
    Authentication getAuthentication(HttpServletRequest request);

    Boolean isTokenValid(HttpServletRequest request);
}
