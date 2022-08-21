package com.example.postservice.web.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreatedRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    @NotNull(message = "UserId is required")
    private Integer userId;
}
