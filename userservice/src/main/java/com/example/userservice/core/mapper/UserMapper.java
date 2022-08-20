package com.example.userservice.core.mapper;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.web.vo.request.UserCreationRequest;
import com.example.userservice.web.vo.request.UserUpdatedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO fromUserCreated(UserCreationRequest creationRequest);
    UserDTO fromUserUpdated(UserUpdatedRequest updatedRequest);
}
