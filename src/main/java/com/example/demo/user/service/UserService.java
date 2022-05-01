package com.example.demo.user.service;

import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDTO;
import com.example.demo.user.model.UserMapperImpl;
import com.example.demo.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAllUsers() throws Exception {
        List<User> userList = userRepository.findAll();
        if (userList.size() == 0){
            throw new Exception("Liste bos!");
        }
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList){
            userDTOList.add(UserMapperImpl.toDTO(user));
        }
        return userDTOList;
    }

    public UserDTO addUser(UserDTO userDTO) throws Exception{
        if (userDTO == null) {
            throw new Exception("Tum alanlar bos olamaz!");
        }
        else if (userDTO.getUsername() == null){
            throw new Exception("Kullanici adi alani bos olamaz!");
        }
        else if(userDTO.getPassword() == null){
            throw new Exception("Sifre alani bos olamaz!");
        }
        User user = userRepository.save(UserMapperImpl.toEntity(userDTO));
        return UserMapperImpl.toDTO(user);
    }

    public UserDTO findUserById(String id) throws Exception {
        if (id == null) {
            throw new Exception("Id bos olamaz!");
        }
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            return UserMapperImpl.toDTO(user);
        }
        return null;
    }

    public Boolean deleteUserById(String id) throws Exception{
        if (id == null) {
            throw new Exception("Id bos olamaz!");
        }
        userRepository.deleteById(id);

        if (findUserById(id) == null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
