package com.example.postservice.core.service.impl;

import com.example.postservice.core.dao.PostDAO;
import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.core.exception.BusinessException;
import com.example.postservice.core.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDAO postDAO;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        postDTO.setCreatedAt(LocalDateTime.now());
        int createPost = postDAO.insert(postDTO);
        if(createPost == 0)
            throw new BusinessException( "Post created error");
        log.info("Post created successfully: {}", createPost);
        return postDAO.findById(postDTO.getId());
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        PostDTO getPost = postDAO.findById(postDTO.getId());
        postDTO.setCreatedAt(getPost.getCreatedAt());
        postDTO.setUpdatedAt(LocalDateTime.now());
        int updatePost = postDAO.update(postDTO);
        if(updatePost == 0)
            throw new BusinessException( "Post updated error");
        log.info("Post updated successfully: {}", updatePost);
        return postDAO.findById(postDTO.getId());
    }

    @Override
    public Integer deletePost(Integer postId) {
        int deletePost = postDAO.deleteById(postId);
        if(deletePost == 0)
            throw new BusinessException( "Post deleted error");
        log.info("Post updated successfully: {}", deletePost);
        return deletePost;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<PostDTO> postDTOList = postDAO.findListPost();
        log.info("Post GetAllPosts: {}", postDTOList);
        return postDTOList;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        log.info("Post GetPostById: {}}", postId);
        return postDAO.findById(postId);
    }
}
