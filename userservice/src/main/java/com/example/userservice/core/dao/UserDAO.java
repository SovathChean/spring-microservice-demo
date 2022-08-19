package com.example.userservice.core.dao;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Repository
@Mapper
public interface UserDAO {
    @Insert("INSERT INTO Users(username, phone, password) " +
            " VALUES ( #{username}, #{phone}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(UserDTO userDTO);
    @Select("Select * From Users Where id=#{userId}")
    public User findUserById(Integer userId);
}
