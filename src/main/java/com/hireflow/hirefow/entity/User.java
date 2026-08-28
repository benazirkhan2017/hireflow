package com.hireflow.hirefow.entity;

import com.hireflow.hirefow.util.IdGeneratorUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Data
public class User {

    @Id
    private String id;

    private String email;

    private String passwordHash;

    private String firstName;

    private String lastName;

    private Instant createdAt;

    private Instant updatedAt;
}
