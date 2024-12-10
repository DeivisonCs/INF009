package com.ecommerce.ecommerce.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    public UserDetails findByEmail(String email);
}
