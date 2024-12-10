package com.ecommerce.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.dto.request.UserRequest;
import org.springframework.web.bind.annotation.RequestBody;
import com.ecommerce.ecommerce.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    // @GetMapping
    // public ResponseEntity<UserDTO> getUserByEmail(){

    // }

}
