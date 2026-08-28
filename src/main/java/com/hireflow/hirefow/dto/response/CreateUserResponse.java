package com.hireflow.hirefow.dto.response;


public record CreateUserResponse(
        String id,
        String email,
        String firstName,
        String lastName
) {
}
