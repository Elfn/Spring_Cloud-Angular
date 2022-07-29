package com.springcloud.gatewayservice.service;

import com.springcloud.gatewayservice.models.Role;
import com.springcloud.gatewayservice.models.User;
import com.springcloud.gatewayservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);

    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    @Override
    @Transactional //Compulsory when executing update or delete feature
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }

}
