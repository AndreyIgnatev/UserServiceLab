package com.aston.home.lab.userservicelab.controller;


import com.aston.home.lab.userservicelab.domain.dto.AccountDTO;
import com.aston.home.lab.userservicelab.domain.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/app/v1/user")
public interface UserController {

    @GetMapping("/all")
    List<User> getAllUsers();

    @GetMapping("/{id}")
    User getUserById(@PathVariable UUID id);

    @PostMapping
    User createUser(@RequestBody User user);

    @PutMapping("/{id}")
    User updateUser(@PathVariable UUID id, @RequestBody User user);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable UUID id);

    @GetMapping("/{userId}/accounts")
    List<AccountDTO> getAllAccountById(@PathVariable UUID userId);
}
