package com.example.postservice.web.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseVO {
    private Integer id;
    private String title;
    private String description;
    private String creator;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
