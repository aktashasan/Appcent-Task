package com.example.demo.user.model;

import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl {

    public static User toEntity(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }

        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public static UserDTO toDTO(User user){
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;

    }
}
