package com.example.userservice.core.mapper;

import com.example.userservice.core.dto.UserCreationDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.web.vo.request.UserCreationRequest;
import com.example.userservice.web.vo.request.UserUpdatedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO fromUserCreated(UserCreationRequest creationRequest);
    UserDTO fromUserUpdated(UserUpdatedRequest updatedRequest);
    List<UserDTO> fromListUserCreationDTO(List<UserCreationDTO> userCreationDTOList);
}
