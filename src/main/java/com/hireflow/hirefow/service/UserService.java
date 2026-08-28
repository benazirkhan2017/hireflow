package com.hireflow.hirefow.service;

import com.hireflow.hirefow.dto.request.CreateUserRequest;
import com.hireflow.hirefow.dto.response.CreateUserResponse;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
