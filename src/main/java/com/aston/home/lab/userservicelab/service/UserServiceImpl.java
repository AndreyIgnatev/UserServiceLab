package com.aston.home.lab.userservicelab.service;

import com.aston.home.lab.userservicelab.domain.dto.AccountDTO;
import com.aston.home.lab.userservicelab.domain.entity.User;
import com.aston.home.lab.userservicelab.integration.BillServiceFeignClient;
import com.aston.home.lab.userservicelab.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServiceRepository userServiceRepository;
    private final BillServiceFeignClient billServiceFeignClient;

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
    public void deleteUser(UUID id) {
        userServiceRepository.deleteById(id);
    }

    @Override
    public List<AccountDTO> getAllAccountById(UUID userId) {
        return billServiceFeignClient.getUserAccountsById(userId.toString()) ;
    }
}
