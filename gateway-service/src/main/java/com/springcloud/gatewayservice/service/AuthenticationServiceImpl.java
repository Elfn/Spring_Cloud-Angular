package com.springcloud.gatewayservice.service;

import com.springcloud.gatewayservice.models.User;
import com.springcloud.gatewayservice.security.UserPrincipal;
import com.springcloud.gatewayservice.security.jwt.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTProvider jwtProvider;

    public User signInAndReturnJWT(User signInRequest){

        // Creating authentication object using User credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        //Returning JWT to the clients
        String jwt = jwtProvider.generateToken(userPrincipal);

        //Extract signIn user from authentication object
        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;

    }

}
