package com.ecommerce.ecommerce.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.dto.request.UserRequest;
import com.ecommerce.ecommerce.mapper.UserMapper;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService{

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email);
    }

    public UserDTO register(UserRequest user){
        user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
        User newUser = this.userRepository.save(UserMapper.RequestToModel(user));

        return UserMapper.toDto(newUser);
    }
}
