package com.example.userservice.core.error;

import com.example.userservice.core.exception.BusinessException;
import com.example.userservice.web.handler.response.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, @NotNull HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        log.error("Validation log: {}", ex.getLocalizedMessage());
        ResponseError apiError =
                new ResponseError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);
    }

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<Object> handleBusinessException(BusinessException ex, HttpHeaders headers, WebRequest request)
    {
        ResponseError apiError =
                new ResponseError(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
        log.error("BusinessException log: {}", ex.getLocalizedMessage());
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);
    }



}
