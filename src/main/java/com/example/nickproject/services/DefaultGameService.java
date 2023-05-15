package com.example.nickproject.services;

import com.example.nickproject.domains.Game;
import com.example.nickproject.repositories.GameRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultGameService implements GameService{

    private final GameRepository gameRepository;

    public DefaultGameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Game> findById(long id) {
        return gameRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void create(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void update(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void delete(Game game) {
        try {
            gameRepository.delete(game);
        }
        catch(EmptyResultDataAccessException ex)
        {

        }
    }
}
