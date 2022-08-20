package com.example.userservice.core.dao;

import com.example.userservice.core.dto.UserDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDAO {
    int insert(UserDTO userDTO);
    UserDTO findUserById(Integer userId);
    List<UserDTO> findListUser();
    int update(UserDTO userDTO);
    int deleteById(Integer userId);
}
