package com.example.userservice.web.handler;

import com.example.userservice.web.handler.response.ResponseData;
import com.example.userservice.web.handler.response.ResponseListData;
import com.example.userservice.web.handler.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseHandler {

    public static <T> ResponseEntity<ResponseData<T>> responseWithData(String message, HttpStatus status, T data, Boolean success)
    {
        ResponseData<T> responseData = new ResponseData<>();
        message = (message == null)? "Request successfully" : message;
        responseData.setData(data);
        responseData.setMessage(message);
        responseData.setSuccess(success);

        return new ResponseEntity<>(responseData, status);
    }
    public static <T> ResponseEntity<ResponseListData<T>> responseWithListData(String message, HttpStatus status, List<T> data, Boolean success)
    {
        ResponseListData<T> responseData = new ResponseListData<>();
        message = (message == null)? "Request successfully" : message;
        responseData.setData(data);
        responseData.setMessage(message);
        responseData.setSuccess(success);

        return new ResponseEntity<>(responseData, status);
    }
    public static ResponseEntity<ResponseMessage> responseWithMsg(String message, HttpStatus status, Boolean success)
    {
        ResponseMessage response = new ResponseMessage();
        message = (message == null)? "Request successfully" : message;
        response.setMessage(message);
        response.setSuccess(success);

        return new ResponseEntity<>(response, status);
    }
}
