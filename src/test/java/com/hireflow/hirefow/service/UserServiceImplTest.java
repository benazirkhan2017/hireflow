package com.hireflow.hirefow.service;

import com.hireflow.hirefow.dto.request.CreateUserRequest;
import com.hireflow.hirefow.dto.response.CreateUserResponse;
import com.hireflow.hirefow.entity.User;
import com.hireflow.hirefow.mapper.UserMapper;
import com.hireflow.hirefow.repository.UserRepository;
import com.hireflow.hirefow.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    public void test_createUser() {

        CreateUserRequest createUserRequest = new CreateUserRequest("benazir@gmail.com",
                "benazir", "khan", "password123");

        User savedUser = User.builder()
                .id("test-id")
                .email("benazir@gmail.com")
                .firstName("benazir")
                .lastName("khan")
                .passwordHash("password123")
                .build();

        CreateUserResponse expectedResponse = new CreateUserResponse(
                "test-id",
                "benazir@gmail.com",
                "benazir",
                "khan");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(userMapper.toResponse(any(User.class))).thenReturn(expectedResponse);

        CreateUserResponse actualResponse = userService.createUser(createUserRequest);

        verify(userRepository).save(any(User.class));
        verify(userMapper).toResponse(savedUser);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }


}
