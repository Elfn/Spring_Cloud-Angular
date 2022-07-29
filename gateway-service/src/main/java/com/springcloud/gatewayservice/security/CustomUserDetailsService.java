package com.springcloud.gatewayservice.security;

import com.springcloud.gatewayservice.models.User;
import com.springcloud.gatewayservice.service.UserService;
import com.springcloud.gatewayservice.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFound = service.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User ["+username+"] not found!"));

        //Autorities according to user role
        Set<GrantedAuthority>  authorities = Set.of(SecurityUtils.convertToAuthority(userFound.getRole().name()));

        //UserDetails
        return UserPrincipal.builder()
                .user(userFound)
                .id(userFound.getId())
                .username(username)
                .password(userFound.getPassword())
                .authorities(authorities)
                .build();

    }
}
