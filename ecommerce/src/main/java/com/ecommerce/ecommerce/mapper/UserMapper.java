package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.dto.request.UserRequest;
import com.ecommerce.ecommerce.model.User;

public class UserMapper {

    public static UserDTO toDto(User user){
        return new UserDTO(user);
    }
    
    public static User RequestToModel(UserRequest user){
        return new User(user);
    }
}
