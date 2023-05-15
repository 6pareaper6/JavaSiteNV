package com.example.nickproject.services;

import com.example.nickproject.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(long id);

    List<User> findAll();

    void create (User user);

    void update (User user);

    void delete (User user);
}
