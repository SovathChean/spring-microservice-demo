package com.example.userservice.web.controller;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.entity.User;
import com.example.userservice.core.service.UserService;
import com.example.userservice.web.handler.ResponseHandler;
import com.example.userservice.web.handler.response.ResponseData;
import com.example.userservice.web.handler.response.ResponseListData;
import com.example.userservice.web.handler.response.ResponseMessage;
import com.example.userservice.web.vo.mapper.UserResponseMapper;
import com.example.userservice.web.vo.response.UserResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping(value="/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ResponseListData<UserResponseVO>> getUserList()
    {
        List<UserResponseVO> userResponseVO = new Vector<>();

        return ResponseHandler.responseWithListData(null, HttpStatus.OK, userResponseVO, true);
    }
    @PostMapping
    public ResponseEntity<ResponseData<UserResponseVO>> createUser(@RequestBody UserDTO userDTO)
    {
        UserDTO createUser = userService.createUser(userDTO);
        UserResponseVO userResponseVO = UserResponseMapper.INSTANCE.fromDTO(createUser);

        return ResponseHandler.responseWithData("Create User successfully", HttpStatus.CREATED, userResponseVO,true);
    }
    @GetMapping(value="{id}")
    public ResponseEntity<ResponseData<UserResponseVO>> getUserBy(@PathVariable Integer id)
    {
        UserDTO user = userService.getUserById(id);
        UserResponseVO userResponseVO = UserResponseMapper.INSTANCE.fromDTO(user);

        return ResponseHandler.responseWithData(null, HttpStatus.OK, userResponseVO, true);
    }

}
