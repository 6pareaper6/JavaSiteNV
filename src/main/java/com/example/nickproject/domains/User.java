package com.example.nickproject.domains;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String usermail;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private int enabled;

    public User() {
    }

    public User(String usermail, @NotNull String username, @NotNull String password, @NotNull int enabled) {
        this.usermail = usermail;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(long id, @NotNull String usermail, @NotNull String username, @NotNull String password, @NotNull int enabled) {
        this.id = id;
        this.usermail = usermail;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public String getUsermail() {
        return usermail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getEnabled() {
        return enabled;
    }
}
