package com.example.userservice.core.service.Impl;

import com.example.userservice.core.dao.UserDAO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDAO.insert(userDTO);
        return userDAO.findUserById(userDTO.getId());
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return userDAO.findUserById(userId);
    }

    @Override
    public List<UserDTO> getListUsers() {
        return userDAO.findListUser();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        userDAO.update(userDTO);
        return userDAO.findUserById(userDTO.getId());
    }

    @Override
    public Integer deleteUser(Integer userId) {
        return userDAO.deleteById(userId);
    }

}
