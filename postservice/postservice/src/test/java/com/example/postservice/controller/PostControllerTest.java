package com.example.postservice.controller;

import com.example.postservice.core.common.constands.BasicUrl;
import com.example.postservice.helper.TestSubmitHelper;
import com.example.postservice.web.handler.response.ResponseData;
import com.example.postservice.web.handler.response.ResponseListData;
import com.example.postservice.web.vo.request.PostCreatedRequest;
import com.example.postservice.web.vo.request.PostUpdatedRequest;
import com.example.postservice.web.vo.response.PostResponseVO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostControllerTest {
    private static final String BasicURI = BasicUrl.BASIC_TEST_URI.label;
    private static final String PostURL = BasicURI + BasicUrl.POST.label;
    private static final String title = "post_title";
    private static final Integer userId = 2;
    private static final Integer postId = 2;
    private static final String description = "post_description";
    private static final String update_post = "update_post";
    private final int port = 9191;

    @Test
    public void should_create_post()
    {
        String url = String.format(PostURL+"/created", port);
        PostCreatedRequest request = new PostCreatedRequest();
        request.setDescription(description);
        request.setTitle(title);
        request.setUserId(userId);
        ResponseEntity<ResponseData<PostResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, request, PostResponseVO.class, HttpMethod.POST);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(Objects.requireNonNull(response.getBody()));
        assertNotNull(response.getBody().getData());
        assertEquals(response.getBody().getData().getTitle(), title);
        assertEquals(response.getBody().getData().getDescription(), description);
    }
    @Test
    public void should_find_post_by_id()
    {
        String url = String.format( PostURL+"/"+postId, port);
        ResponseEntity<ResponseData<PostResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, null, PostResponseVO.class, HttpMethod.GET);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(Objects.requireNonNull(response.getBody()));
        assertNotNull(response.getBody().getData());
    }
    @Test
    public void should_find_list_post()
    {
        String url = String.format( PostURL, port);
        ResponseEntity<ResponseListData<PostResponseVO>> response = new TestSubmitHelper()
                .submitListDataResponse(url, null, PostResponseVO.class, HttpMethod.GET);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void should_updated_user()
    {
        String url = String.format( PostURL+"/updated", port);
        PostUpdatedRequest request = new PostUpdatedRequest();
        request.setDescription(description);
        request.setTitle(update_post);
        request.setUserId(userId);
        request.setId(postId);
        ResponseEntity<ResponseData<PostResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, request, PostResponseVO.class, HttpMethod.POST);
        System.out.println(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(Objects.requireNonNull(response.getBody()));
        assertNotNull(response.getBody().getData());
        assertEquals(response.getBody().getData().getTitle(), update_post);
    }
    @Test
    public void should_deleted_user()
    {
        String url = String.format( PostURL+"/deleted/4", port);
        ResponseEntity<ResponseData<PostResponseVO>> response = new TestSubmitHelper()
                .submitSingleDataResponse(url, null, PostResponseVO.class, HttpMethod.GET);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
