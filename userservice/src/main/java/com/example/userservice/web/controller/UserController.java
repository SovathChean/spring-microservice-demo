package com.example.userservice.web.controller;

import com.example.userservice.core.dto.UserDTO;
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

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/api/users", method = RequestMethod.GET)
    public ResponseEntity<ResponseListData<UserResponseVO>> getUserList() {
        List<UserDTO> userDTOList = userService.getListUsers();
        List<UserResponseVO> userResponseVO = UserResponseMapper.INSTANCE.fromListDTO(userDTOList);

        return ResponseHandler.responseWithListData(null, HttpStatus.OK, userResponseVO, true);
    }

    @RequestMapping(value="/api/users/created", method = RequestMethod.POST)
    public ResponseEntity<ResponseData<UserResponseVO>> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createUser = userService.createUser(userDTO);
        UserResponseVO userResponseVO = UserResponseMapper.INSTANCE.fromDTO(createUser);

        return ResponseHandler.responseWithData("Create User successfully", HttpStatus.CREATED, userResponseVO, true);
    }

    @RequestMapping(value="/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData<UserResponseVO>> getUserBy(@PathVariable Integer id) {
        UserDTO user = userService.getUserById(id);
        UserResponseVO userResponseVO = UserResponseMapper.INSTANCE.fromDTO(user);

        return ResponseHandler.responseWithData(null, HttpStatus.OK, userResponseVO, true);
    }

    @RequestMapping(value = "/api/users/updated", method = RequestMethod.POST)
    public ResponseEntity<ResponseData<UserResponseVO>> updateUser(@RequestBody UserDTO userDTO)
    {
        UserDTO updateUser = userService.updateUser(userDTO);
        UserResponseVO userResponseVO = UserResponseMapper.INSTANCE.fromDTO(updateUser);

        return ResponseHandler.responseWithData("Update user successfully", HttpStatus.OK, userResponseVO, true);
    }
    @RequestMapping(value = "/api/users/deleted/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Integer id)
    {
        Integer deleteUser = userService.deleteUser(id);
        if(deleteUser == 0)
            return ResponseHandler.responseWithMsg("Delete has failed", HttpStatus.BAD_REQUEST, false );


        return ResponseHandler.responseWithMsg("Delete successfully", HttpStatus.OK, true );
    }
}
