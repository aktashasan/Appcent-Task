package com.example.demo.user.service;

import com.example.demo.builder.user.UserBuilder;
import com.example.demo.user.model.UserDTO;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureDataMongo
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAllUsers() throws Exception {
        userRepository.deleteAll();
        UserDTO userDTO = new UserBuilder()
                .buildSomeDummy()
                .build();
        userService.addUser(userDTO);
        List<UserDTO> userDTOList = userService.findAllUsers();
        Assertions.assertEquals(1,userDTOList.size());

    }

    @Test
    void addUser() throws Exception {
        userRepository.deleteAll();
        UserDTO userDTO = new UserBuilder()
                .buildSomeDummy()
                .build();
        UserDTO savedUser = userService.addUser(userDTO);
        Assertions.assertNotNull(savedUser.getId());
    }

    @Test
    void findUserById() throws Exception {
        userRepository.deleteAll();
        UserDTO userDTO = new UserBuilder()
                .buildSomeDummy()
                .build();
        UserDTO savedUser = userService.addUser(userDTO);
        UserDTO findUser = userService.findUserById(savedUser.getId());
        Assertions.assertNotNull(findUser);
    }

    @Test
    void deleteUserById() throws Exception {
        UserDTO userDTO = new UserBuilder()
                .buildSomeDummy()
                .build();
        UserDTO savedUser = userService.addUser(userDTO);
        Boolean deletedUser = userService.deleteUserById(savedUser.getId());
        Assertions.assertEquals(deletedUser,Boolean.TRUE);
    }
}