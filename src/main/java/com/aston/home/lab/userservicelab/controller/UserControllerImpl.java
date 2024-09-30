package com.aston.home.lab.userservicelab.controller;

import com.aston.home.lab.userservicelab.domain.dto.AccountDTO;
import com.aston.home.lab.userservicelab.domain.entity.User;
import com.aston.home.lab.userservicelab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User getUserById(UUID id) {
        return userService.getUserById(id);
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(UUID id, User user) {
        return userService.updateUser(id,user);
    }

    @Override
    public void deleteUser(UUID id) {
        userService.deleteUser(id);
    }

    @Override
    public List<AccountDTO> getAllAccountById(UUID userId) {
        return userService.getAllAccountById(userId);
    }
}
