package com.example.nickproject.repositories;

import com.example.nickproject.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
