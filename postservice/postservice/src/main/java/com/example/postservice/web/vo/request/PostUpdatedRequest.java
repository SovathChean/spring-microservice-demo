package com.example.postservice.web.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdatedRequest {
    @NotNull(message = "Post id is required")
    private Integer id;
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    @NotNull(message = "UserId is required")
    private Integer userId;

}
