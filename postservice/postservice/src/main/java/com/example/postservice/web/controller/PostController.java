package com.example.postservice.web.controller;

import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.core.mapper.PostMapper;
import com.example.postservice.core.service.PostService;
import com.example.postservice.web.handler.ResponseHandler;
import com.example.postservice.web.handler.response.ResponseData;
import com.example.postservice.web.handler.response.ResponseListData;
import com.example.postservice.web.handler.response.ResponseMessage;
import com.example.postservice.web.vo.mapper.PostResponseMapperVO;
import com.example.postservice.web.vo.request.PostCreatedRequest;
import com.example.postservice.web.vo.request.PostUpdatedRequest;
import com.example.postservice.web.vo.response.PostResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private Environment environment;
    @RequestMapping(value="/api/posts", method = RequestMethod.GET)
    public ResponseEntity<ResponseListData<PostResponseVO>> getPosts() {
        List<PostDTO> postDTOS = postService.getAllPosts();
        List<PostResponseVO> postResponseVOS = PostResponseMapperVO.INSTANCE.fromListPostDTO(postDTOS);

        return ResponseHandler.responseWithListData(null, HttpStatus.OK, postResponseVOS, true);
    }
    @RequestMapping(value="/api/posts/port", method = RequestMethod.GET)
    public ResponseEntity<ResponseMessage> getServicePort() {
        String serverPort = environment.getProperty("local.server.port");


        String port =  "I am a REST API in client 2 running on port "+serverPort;

        return ResponseHandler.responseWithMsg(port, HttpStatus.OK, true);
    }

    @RequestMapping(value="/api/posts/created", method = RequestMethod.POST)
    public ResponseEntity<ResponseData<PostResponseVO>> createPost(@Validated @RequestBody PostCreatedRequest creationRequest) {
        PostDTO createPost = postService.createPost(PostMapper.INSTANCE.fromPostCreated(creationRequest));
        PostResponseVO postResponseVO = PostResponseMapperVO.INSTANCE.fromPostDTO(createPost);

        return ResponseHandler.responseWithData("Create Post successfully", HttpStatus.CREATED, postResponseVO, true);
    }

    @RequestMapping(value="/api/posts/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData<PostResponseVO>> getPostById(@PathVariable Integer id) {
        PostDTO post = postService.getPostById(id);
        PostResponseVO postResponseVO = PostResponseMapperVO.INSTANCE.fromPostDTO(post);

        return ResponseHandler.responseWithData(null, HttpStatus.OK, postResponseVO, true);
    }

    @RequestMapping(value = "/api/posts/updated", method = RequestMethod.POST)
    public ResponseEntity<ResponseData<PostResponseVO>> updatePost(@Validated @RequestBody PostUpdatedRequest postUpdatedRequest)
    {
        PostDTO updatePost = postService.updatePost(PostMapper.INSTANCE.fromPostUpdated(postUpdatedRequest));
        PostResponseVO postResponseVO = PostResponseMapperVO.INSTANCE.fromPostDTO(updatePost);

        return ResponseHandler.responseWithData("Update user successfully", HttpStatus.OK, postResponseVO, true);
    }
    @RequestMapping(value = "/api/posts/deleted/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Integer id)
    {
        Integer deletePost = postService.deletePost(id);
        if(deletePost == 0)
            return ResponseHandler.responseWithMsg("Delete has failed", HttpStatus.BAD_REQUEST, false );

        return ResponseHandler.responseWithMsg("Delete successfully", HttpStatus.OK, true );
    }
}
