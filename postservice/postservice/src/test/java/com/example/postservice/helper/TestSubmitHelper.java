package com.example.postservice.helper;

import com.example.postservice.web.handler.response.ResponseData;
import com.example.postservice.web.handler.response.ResponseListData;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TestSubmitHelper {
    public <T, E> ResponseEntity<ResponseData<T>> submitSingleDataResponse(String endpoint, E body, Class<T> classType, HttpMethod method)
    {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        var request =  HttpHelper.getHttpEntity(body);
        var typeReference = new GenericClassHelper().getParameterizedTypeRef(ResponseData.class, classType);
        return testRestTemplate.exchange(endpoint, method, request, typeReference);
    }
    public <T, E> ResponseEntity<ResponseListData<T>> submitListDataResponse(String endpoint, List<E> body, Class<T> classType, HttpMethod method)
    {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        var request =  HttpHelper.getHttpEntity(body);
        var typeReference = new GenericClassHelper().getParameterizedTypeRef(ResponseListData.class, classType);
        return testRestTemplate.exchange(endpoint, method, request, typeReference);
    }
}
