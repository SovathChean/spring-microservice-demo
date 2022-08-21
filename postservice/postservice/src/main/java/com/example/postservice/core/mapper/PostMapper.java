package com.example.postservice.core.mapper;

import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.web.vo.request.PostCreatedRequest;
import com.example.postservice.web.vo.request.PostUpdatedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    PostDTO fromPostCreated(PostCreatedRequest postCreatedRequest);
    PostDTO fromPostUpdated(PostUpdatedRequest postUpdatedRequest);
}
