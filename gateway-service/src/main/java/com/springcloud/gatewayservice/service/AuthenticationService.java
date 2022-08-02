package com.springcloud.gatewayservice.service;

import com.springcloud.gatewayservice.models.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
