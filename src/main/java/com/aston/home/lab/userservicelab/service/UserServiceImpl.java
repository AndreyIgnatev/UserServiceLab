package com.aston.home.lab.userservicelab.service;

import com.aston.home.lab.userservicelab.model.User;
import com.aston.home.lab.userservicelab.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServiceRepository userServiceRepository;

    @Override
    public List<User> getAllUsers() {
        return userServiceRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userServiceRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(User user) {
        return userServiceRepository.save(user);
    }

    @Override
    public User updateUser(UUID id, User user) {
        User userNew = userServiceRepository.getById(id);
        userNew.setName(user.getName());
        userNew.setAge(user.getAge());
        userNew.setLastName(user.getLastName());
        userServiceRepository.save(userNew);
        return userNew;

    }

    @Override
    public void patchUser(UUID id, User user) {

    }

    @Override
    public void deleteUser(UUID id) {
        userServiceRepository.deleteById(id);
    }
}
