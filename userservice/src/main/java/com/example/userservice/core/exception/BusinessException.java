package com.example.userservice.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private String message;
    private HttpStatus status;
}
