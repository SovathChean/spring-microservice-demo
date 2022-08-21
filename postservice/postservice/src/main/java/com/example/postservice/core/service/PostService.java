package com.example.postservice.core.service;

import com.example.postservice.core.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    PostDTO updatePost(PostDTO postDTO);
    Integer deletePost(Integer postId);
    List<PostDTO> getAllPosts();
    PostDTO getPostById(Integer id);

}
