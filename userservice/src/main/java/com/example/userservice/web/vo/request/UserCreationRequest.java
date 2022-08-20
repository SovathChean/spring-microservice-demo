package com.example.userservice.web.vo.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {
    @NotBlank(message = "username is required.")
    private String username;
    @NotBlank
    private String phone;
    @NotBlank
    private String password;
}
