package com.springcloud.gatewayservice.security.jwt;

import com.springcloud.gatewayservice.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JWTProvider {

    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
