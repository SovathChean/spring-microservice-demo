package com.example.userservice.core.service.Impl;

import com.example.userservice.core.dao.UserDAO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.exception.BusinessException;
import com.example.userservice.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Integer userCreation = userDAO.insert(userDTO);
        if(userCreation == 0)
            throw new BusinessException( "User creation error");
        UserDTO user = userDAO.findUserById(userDTO.getId());
        log.info("User created successfully: {}", user);

        return user;
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        log.info("Find UserById:", userId);
        return userDAO.findUserById(userId);
    }

    @Override
    public List<UserDTO> getListUsers() {
        log.info("Find ListByUsers: {}");
        return userDAO.findListUser();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Integer updateUser = userDAO.update(userDTO);
        if(updateUser == 0)
            throw new BusinessException( "User Updated error");
        log.info("Update user successfully user-id: ", userDTO.getId());
        return userDAO.findUserById(userDTO.getId());
    }

    @Override
    public Integer deleteUser(Integer userId) {
        Integer deleteUser = userDAO.deleteById(userId);
        if(deleteUser == 0)
            throw new BusinessException( "User creation error");
        log.info("Delete user successfully user-id: ", userId);
        return deleteUser;
    }

}
