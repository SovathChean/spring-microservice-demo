package com.example.userservice.web.vo.mapper;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.web.vo.response.UserResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    public  UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);
    UserResponseVO fromDTO(UserDTO userDTO);
    List<UserResponseVO> fromListDTO(List<UserDTO> userDTOList);
}
