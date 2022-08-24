package com.example.postservice.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@AllArgsConstructor
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public final class BusinessException  extends  RuntimeException{
    String message;
}
