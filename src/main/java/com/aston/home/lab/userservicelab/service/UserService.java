package com.aston.home.lab.userservicelab.service;

import com.aston.home.lab.userservicelab.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(UUID id);

    public User createUser(User user);

    public User updateUser(UUID id, User user);

    public void patchUser(UUID id, User user);

    public void deleteUser(UUID id);

}
