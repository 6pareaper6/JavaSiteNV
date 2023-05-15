package com.example.nickproject.repositories;

import com.example.nickproject.domains.Game;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql ("/insertGame.sql")
public class GameRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final GameRepository repository;

    public GameRepositoryTest(GameRepository repository) {
        this.repository = repository;
    }

    private long idOfGame()
    {
        return super.jdbcTemplate.queryForObject(
                "select id from games where name = 'testGame'", Long.class);
    }

    @Test
    void findById()
    {
        assertThat(repository.findById(idOfGame()).get().getSteamid()).isEqualTo(100);
    }

    @Test
    void findAll()
    {
        var rows = super.countRowsInTable("games");
        assertThat(rows).isEqualTo(repository.findAll().size());
    }

    @Test
    void save()
    {
        var game = repository.save(new Game(5, "testGame2"));
        assertThat(super.countRowsInTableWhere("games","id="+game.getId())).isOne();
    }

    @Test
    void update()
    {
        var id = idOfGame();
        var game = new Game(id, 1, "testGame3");
        repository.save(game);
        assertThat(repository.findById(id).get().getSteamid()).isOne();
    }

    @Test
    void delete()
    {
        var id = idOfGame();
        repository.delete(repository.findById(id).get());
        assertThat(repository.findById(id)).isEmpty();
    }

}
