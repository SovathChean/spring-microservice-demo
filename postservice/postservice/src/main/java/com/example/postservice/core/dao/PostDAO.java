package com.example.postservice.core.dao;

import com.example.postservice.core.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostDAO {
    int insert(PostDTO postDTO);
    int update(PostDTO postDTO);
    int deleteById(Integer postId);
    List<PostDTO> findListPost();
    PostDTO findById(Integer postId);
}
