package com.example.nickproject.repositories;

import com.example.nickproject.domains.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
