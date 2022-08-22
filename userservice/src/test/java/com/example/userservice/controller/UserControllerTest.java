package com.example.userservice.controller;

import com.example.userservice.core.common.constant.BasicUrl;
import com.example.userservice.helper.TestSubmitHelper;
import com.example.userservice.web.handler.response.ResponseData;
import com.example.userservice.web.handler.response.ResponseListData;
import com.example.userservice.web.vo.request.UserCreationRequest;
import com.example.userservice.web.vo.request.UserUpdatedRequest;
import com.example.userservice.web.vo.response.UserResponseVO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserControllerTest {
    private static final String BasicURI = BasicUrl.BASIC_TEST_URI.label;
    private static final String UserURI = BasicURI + BasicUrl.USER.label;
    private static final String username = "useradmin";
    private static final Integer userId = 1;
    private static final String password = "password";
    private static final String phone="092899999";
    private static final String updated_username = "updated_username";
    private final int port = 9191;
    @Test
    public void should_created_user()
    {
        String url = String.format( UserURI+"/created", port);
        UserCreationRequest request = new UserCreationRequest();
        request.setPassword(password);
        request.setUsername(username);
        request.setPhone(phone);
        ResponseEntity<ResponseData<UserResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, request, UserResponseVO.class, HttpMethod.POST);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData());
        assertEquals(response.getBody().getData().getUsername(), username);
        assertEquals(response.getBody().getData().getPhone(), phone);

    }
    @Test
    public void should_find_user_by_id()
    {
        String url = String.format( UserURI+"/"+userId, port);
        ResponseEntity<ResponseData<UserResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, null, UserResponseVO.class, HttpMethod.GET);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData());
    }
    @Test
    public void should_find_list_user()
    {
        String url = String.format( UserURI, port);
        ResponseEntity<ResponseListData<UserResponseVO>> response = new TestSubmitHelper()
                .submitListDataResponse(url, null, UserResponseVO.class, HttpMethod.GET);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void should_updated_user()
    {
        String url = String.format( UserURI+"/updated", port);
        UserUpdatedRequest request = new UserUpdatedRequest();
        request.setPassword(password);
        request.setUsername(updated_username);
        request.setId(userId);
        request.setPhone(phone);
        ResponseEntity<ResponseData<UserResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, request, UserResponseVO.class, HttpMethod.POST);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData());
        assertEquals(response.getBody().getData().getUsername(), updated_username);
    }
    @Test
    public void should_deleted_user()
    {
        String url = String.format( UserURI+"/deleted/"+userId, port);
        ResponseEntity<ResponseData<UserResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, null, UserResponseVO.class, HttpMethod.GET);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
