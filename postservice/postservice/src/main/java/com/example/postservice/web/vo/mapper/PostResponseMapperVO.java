package com.example.postservice.web.vo.mapper;

import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.web.vo.response.PostResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PostResponseMapperVO {
    PostResponseMapperVO INSTANCE = Mappers.getMapper(PostResponseMapperVO.class);

    List<PostResponseVO> fromListPostDTO(List<PostDTO> postDTOS);
    PostResponseVO fromPostDTO(PostDTO postDTO);
}
