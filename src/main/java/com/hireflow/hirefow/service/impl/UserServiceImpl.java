package com.hireflow.hirefow.service.impl;

import com.hireflow.hirefow.dto.request.CreateUserRequest;
import com.hireflow.hirefow.dto.response.CreateUserResponse;
import com.hireflow.hirefow.entity.User;
import com.hireflow.hirefow.mapper.UserMapper;
import com.hireflow.hirefow.repository.UserRespository;
import com.hireflow.hirefow.service.UserService;
import com.hireflow.hirefow.util.IdGeneratorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;
    private final UserMapper userMapper;

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        User user = User.builder()
                .id(IdGeneratorUtil.generateUUID())
                .email(createUserRequest.email())
                .firstName(createUserRequest.firstName())
                .lastName(createUserRequest.lastName())
                .createdAt(Instant.now())
                .passwordHash(createUserRequest.passwordHash())
                .build();

        User savedUser = userRespository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
