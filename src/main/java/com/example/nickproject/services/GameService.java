package com.example.nickproject.services;

import com.example.nickproject.domains.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    Optional<Game> findById(long id);

    List<Game> findAll();

    void create (Game game);

    void update(Game game);

    void delete(Game game);
}
