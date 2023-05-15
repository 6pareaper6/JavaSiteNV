package com.example.nickproject.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/insertRole.sql")
public class RoleRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final RoleRepository repository;

    public RoleRepositoryTest(RoleRepository repository) {
        this.repository = repository;
    }

    private long idOfRole()
    {
        return super.jdbcTemplate.queryForObject("select id from roles where role = 'testRole'", Long.class);
    }

    @Test
    void findById() {
        assertThat(repository.findById(idOfRole()).get().getRole()).isEqualTo("testRole");
    }

    @Test
    void findAll()
    {
        assertThat(super.countRowsInTable("roles")).isEqualTo(repository.findAll().size());
    }
}
