package com.springcloud.gatewayservice.repository;

import com.springcloud.gatewayservice.models.Role;
import com.springcloud.gatewayservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    // Modification signature
    @Modifying
    @Query("UPDATE User SET role = :role WHERE username = :username")
    void updateUserRole(@Param("username") String username,@Param("role") Role role);
}
