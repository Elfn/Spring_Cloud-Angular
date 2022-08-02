package com.springcloud.gatewayservice.controllers;

import com.springcloud.gatewayservice.models.User;
import com.springcloud.gatewayservice.service.AuthenticationService;
import com.springcloud.gatewayservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;
    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public ResponseEntity<?> SignUp(@RequestBody User user){

        if(userService.findByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

    }

    @PostMapping("signin")
    public ResponseEntity<?> SignIn(@RequestBody User user){

        return new ResponseEntity<>(authService.signInAndReturnJWT(user), HttpStatus.OK);

    }

}
