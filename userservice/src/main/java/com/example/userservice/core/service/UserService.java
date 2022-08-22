package com.example.userservice.core.service;

import com.example.userservice.core.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getListUsers();
    UserDTO updateUser(UserDTO userDTO);
    Integer deleteUser(Integer userId);
}
