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
        UserDTO user = this.getUserById(userDTO.getId());
        return user;
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        UserDTO user = userDAO.findUserById(userId);

        return user;
    }
}
