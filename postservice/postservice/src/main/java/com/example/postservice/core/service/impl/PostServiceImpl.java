package com.example.postservice.core.service.impl;

import com.example.postservice.core.dao.PostDAO;
import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.core.exception.BusinessException;
import com.example.postservice.core.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDAO postDAO;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        postDTO.setCreatedAt(LocalDateTime.now());
        Integer createPost = postDAO.insert(postDTO);
        if(createPost == 0)
            throw new BusinessException( "User created error");
        return postDAO.findById(postDTO.getId());
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        PostDTO getPost = postDAO.findById(postDTO.getId());
        postDTO.setCreatedAt(getPost.getCreatedAt());
        postDTO.setUpdatedAt(LocalDateTime.now());
        Integer updatePost = postDAO.update(postDTO);
        if(updatePost == 0)
            throw new BusinessException( "Post updated error");
        return postDAO.findById(postDTO.getId());
    }

    @Override
    public Integer deletePost(Integer postId) {
        Integer deletePost = postDAO.deleteById(postId);
        if(deletePost == 0)
            throw new BusinessException( "Post deleted error");
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
