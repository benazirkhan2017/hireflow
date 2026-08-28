package com.hireflow.hirefow.repository;

import com.hireflow.hirefow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, String> {
}
