package com.example.demo.user.controller;

import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDTO;
import com.example.demo.user.model.UserMapperImpl;
import com.example.demo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@AllArgsConstructor
public class UserResource {

    private UserService userService;

    @PostMapping("/user/save")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) throws Exception{
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @GetMapping("/user/get/id/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id) throws Exception{
        UserDTO userDTO =userService.findUserById(id);
        if (userDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/user/delete/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @GetMapping("/user/get/usernameAndPassword/{username}/{password}")
    public ResponseEntity<UserDTO> findUserByUsernameAndPassword(@PathVariable String username,
                                                                 @PathVariable String password){
        return ResponseEntity.ok(userService.findUserByUsernameAndPassword(username,password));
    }

    @GetMapping("/user/get/username/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username){
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UserMapperImpl.toDTO(user));
    }

    @GetMapping("/users/get")
    public ResponseEntity<List<UserDTO>> findAllUsers() throws Exception{

        return ResponseEntity.ok(userService.findAllUsers());
    }

}
