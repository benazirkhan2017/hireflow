package com.hireflow.hirefow.service.impl;

import com.hireflow.hirefow.dto.request.CreateUserRequest;
import com.hireflow.hirefow.dto.response.CreateUserResponse;
import com.hireflow.hirefow.entity.User;
import com.hireflow.hirefow.exception.ApiException;
import com.hireflow.hirefow.mapper.UserMapper;
import com.hireflow.hirefow.repository.UserRepository;
import com.hireflow.hirefow.service.UserService;
import com.hireflow.hirefow.util.IdGeneratorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        if (isBlank(createUserRequest.email()))
            throw new ApiException("Email id cannot be blank or null");

        User user = User.builder()
                .id(IdGeneratorUtil.generateUUID())
                .email(createUserRequest.email())
                .firstName(createUserRequest.firstName())
                .lastName(createUserRequest.lastName())
                .createdAt(Instant.now())
                .passwordHash(createUserRequest.passwordHash())
                .build();

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
