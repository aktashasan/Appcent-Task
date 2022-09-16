package com.example.demo.user.authentication;

import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDTO;
import com.example.demo.user.model.UserMapperImpl;
import com.example.demo.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/app")
@Slf4j
public class AuthenticationResource {
    private final UserService userService;

    private final UserMapperImpl userMapper;

    @GetMapping(path = "/login")
    public ResponseEntity<UserDTO> login(){
        User user = userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        log.info(String.valueOf(user));

        return ResponseEntity.ok(userMapper.toDTO(user));
    }
}
