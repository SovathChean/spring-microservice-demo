package com.example.userservice.web.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatedRequest {
    @NotNull(message = "id is required.")
    private Integer id;
    @NotBlank
    private String username;
    @NotBlank
    private String phone;
    @NotBlank
    private String password;
}
