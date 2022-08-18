package com.example.userservice.web.controller;

import com.example.userservice.core.service.UserService;
import com.example.userservice.web.handler.ResponseHandler;
import com.example.userservice.web.handler.response.ResponseListData;
import com.example.userservice.web.vo.response.UserResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
