package com.example.postservice.core.service.impl;

import com.example.postservice.core.dao.PostDAO;
import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.core.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDAO postDAO;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Integer createPost = postDAO.insert(postDTO);
        return postDAO.findById(postDTO.getId());
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        Integer updatePost = postDAO.update(postDTO);
        return postDAO.findById(postDTO.getId());
    }

    @Override
    public Integer deletePost(Integer postId) {
        Integer deletePost = postDAO.deleteById(postId);
        return deletePost;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postDAO.findListPost();
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        return postDAO.findById(postId);
    }
}
