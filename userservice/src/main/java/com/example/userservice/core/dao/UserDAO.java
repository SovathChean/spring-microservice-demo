package com.example.userservice.core.dao;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Repository
@Mapper
public interface UserDAO {
    public int insert(UserDTO userDTO);
    public User findUserById(Integer userId);
}
