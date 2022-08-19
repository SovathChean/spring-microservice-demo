package com.example.userservice.core.service.Impl;

import com.example.userservice.core.dao.UserDAO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.entity.User;
import com.example.userservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Integer createUser = userDAO.insert(userDTO);
        System.out.println(userDTO.getId());
        return userDTO;
    }

    @Override
    public User getUserById(Integer userId) {
        User user = userDAO.findUserById(userId);
        return user;
    }
}
