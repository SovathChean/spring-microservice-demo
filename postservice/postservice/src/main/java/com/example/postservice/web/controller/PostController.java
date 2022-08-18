package com.example.postservice.web.controller;

import com.example.postservice.core.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping
    public ResponseEntity<Object> getPosts()
    {
        return ResponseEntity.ok("Post successfully");
    }
}
