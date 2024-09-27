package com.aston.home.lab.userservicelab.repository;

import com.aston.home.lab.userservicelab.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserServiceRepository extends JpaRepository<User,UUID> {
}
