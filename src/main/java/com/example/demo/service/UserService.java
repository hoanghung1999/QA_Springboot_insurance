package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUser();
    public User saveUser(User user);
    public void deleteUserById(Long id);
    public Optional<User> findUserById(Long id);
    public List<User> findUserByName(String name);
    public  List<User> findUserByInsurName(String name);

}