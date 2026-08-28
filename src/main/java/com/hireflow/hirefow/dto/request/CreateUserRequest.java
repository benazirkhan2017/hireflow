package com.hireflow.hirefow.dto.request;

public record CreateUserRequest( String email,
                                 String passwordHash,
                                 String firstName,
                                 String lastName) {
}
