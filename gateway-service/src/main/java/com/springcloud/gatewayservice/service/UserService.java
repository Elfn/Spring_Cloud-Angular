package com.springcloud.gatewayservice.service;

import com.springcloud.gatewayservice.models.Role;
import com.springcloud.gatewayservice.models.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
