package com.example.demo.user.controller;

import com.example.demo.builder.user.UserBuilder;
import com.example.demo.user.model.UserDTO;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
class AuthenticationResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @WithMockUser(username = "admin", password = "admin")
    void login() throws Exception {
        userRepository.deleteAll();

        UserDTO userDTO = new UserBuilder()
                .buildSomeDummy()
                .withUsername("admin")
                .withPassword("admin")
                .build();
        UserDTO savedUser = userService.addUser(userDTO);

        ResultActions resultActions = this.mockMvc
                .perform(get("/app/login" ))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        UserDTO result = objectMapper.readValue(contentAsString,UserDTO.class);
        Assertions.assertEquals(savedUser,result);
    }
}