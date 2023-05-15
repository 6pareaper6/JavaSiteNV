package com.example.nickproject.repositories;

import com.example.nickproject.domains.Review;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/insertGame.sql")
@Sql("/insertReview.sql")
public class ReviewRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final ReviewRepository repository;

    public ReviewRepositoryTest(ReviewRepository repository) {
        this.repository = repository;
    }


    private long idVanTestReview()
    {
        return super.jdbcTemplate.queryForObject("select id from reviews where steam_id = '100'", Long.class);
    }

    @Test
    void findbyid()
    {
        assertThat(repository.findById(idVanTestReview()).get().getSteamId()).isEqualTo(100);
    }

    @Test
    void save()
    {
        var review = repository.save(new Review(1,"test",1,2, LocalDate.now()));
        assertThat(super.countRowsInTableWhere("reviews","id="+review.getId())).isOne();
    }

    @Test
    void update()
    {
        var rev = repository.findById(idVanTestReview()).get();
        var review = new Review(rev.getId(), rev.getSteamId(), "edit review", 1, 2, LocalDate.now());
        repository.save(review);
        assertThat(repository.findById(rev.getId()).get().getReview()).isEqualTo("edit review");
    }

    @Test
    void delete()
    {
        var id = idVanTestReview();
        repository.delete(repository.findById(id).get());
        assertThat(repository.findById(id)).isEmpty();
    }


}
