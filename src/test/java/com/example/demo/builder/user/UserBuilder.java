package com.example.demo.builder.user;

import com.example.demo.user.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserBuilder {

    private UserDTO userDTO = new UserDTO();

    public UserBuilder buildSomeDummy(){
        this.userDTO.setUsername("aktashasan");
        this.userDTO.setPassword("12345");

        return this;
    }

    public UserBuilder withUsername(String username){
        this.userDTO.setUsername(username);
        return this;
    }

    public UserBuilder withPassword(String password){
        this.userDTO.setPassword(password);
        return this;
    }

    public UserDTO build(){
        return this.userDTO;
    }
}
