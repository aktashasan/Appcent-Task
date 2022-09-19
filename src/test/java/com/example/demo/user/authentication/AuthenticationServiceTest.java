package com.example.demo.user.authentication;

import com.example.demo.builder.user.UserBuilder;
import com.example.demo.user.model.UserDTO;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void authenticate() throws Exception {
//        userRepository.deleteAll();
//
//        UserDTO userDTO = new UserBuilder()
//                .withUsername("admin")
//                .withPassword("admin")
//                .build();
//        UserDTO savedUser = userService.addUser(userDTO);
//
//        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(savedUser.getUsername(),savedUser.getPassword());
//
//        Assertions.assertNotNull(this.authenticationService.authenticate(token));
    }

}