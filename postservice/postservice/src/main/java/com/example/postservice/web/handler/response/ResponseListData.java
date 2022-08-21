package com.example.postservice.web.handler.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListData<T> {
    private String message;
    private List<T> data;
    private Boolean success;
}
