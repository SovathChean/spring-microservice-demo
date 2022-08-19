package com.example.userservice.core.service;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.entity.User;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    User getUserById(Integer userId);
}
