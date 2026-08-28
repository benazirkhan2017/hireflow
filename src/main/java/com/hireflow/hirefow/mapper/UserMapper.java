package com.hireflow.hirefow.mapper;

import com.hireflow.hirefow.dto.response.CreateUserResponse;
import com.hireflow.hirefow.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    CreateUserResponse toResponse(User user);
}
