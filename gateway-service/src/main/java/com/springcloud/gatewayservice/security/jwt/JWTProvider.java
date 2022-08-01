package com.springcloud.gatewayservice.security.jwt;

import com.springcloud.gatewayservice.security.UserPrincipal;

public interface JWTProvider {

    String generateToken(UserPrincipal auth);
}
