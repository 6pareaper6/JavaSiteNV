package com.example.nickproject.domains;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long steamid;
    @NotBlank
    private String name;

    protected Game() {

    }

    public Game(long steamid, String name) {
        this.steamid = steamid;
        this.name = name;
    }

    public Game(long id, long steamid, String name)
    {
        this.id = id;
        this.steamid = steamid;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getSteamid() {
        return steamid;
    }

    public String getName() {
        return name;
    }
}
