package com.example.postservice.web.controller;

import com.example.postservice.core.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostServiceController {
    @Autowired
    private PostService postService;
    
}
