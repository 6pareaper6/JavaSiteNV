package com.example.nickproject.repositories;

import com.example.nickproject.domains.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Sql("/insertUser.sql")
public class UserRepositoryTest  extends AbstractTransactionalJUnit4SpringContextTests {

    private final UserRepository repository;

    public UserRepositoryTest(UserRepository userRepository) {
        this.repository = userRepository;
    }

    private long idOfUser()
    {
        return super.jdbcTemplate.queryForObject("select id from users where username = 'login2'", Long.class);
    }

    @Test
    void findById()
    {
        var optionalUser = repository.findById(idOfUser());
        assertThat(optionalUser.get().getUsername()).isEqualTo("login2");
    }

    @Test
    void findAll()
    {
        var rows = super.countRowsInTable("users");
        assertThat(rows).isEqualTo(repository.findAll().size());

    }

    @Test
    void register()
    {
        var user = repository.save(new User("nope@nope.nope", "login3", "password3", 1));
        assertThat(super.countRowsInTableWhere("users", "username = "+user.getId())).isOne();
    }

    @Test
    void update()
    {
        var id = idOfUser();
        var user = new User(id, "newmail@newmail.newmail", "newlogin", "newpass",1);
        repository.save(user);
        assertThat(repository.findById(id).get().getUsername()).isEqualTo("newlogin");
    }

    @Test
    void delete()
    {
        var id = idOfUser();
        repository.delete(repository.findById(id).get());
        assertThat(repository.findById(id)).isEmpty();
    }
}
