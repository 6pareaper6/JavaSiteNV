package com.example.nickproject.domains;

import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long steamId;

    @NotBlank
    private String review;
    @NotNull
    private long thumbsUp;

    @NotNull
    private long thumbsDown;

    @NotNull
    @DateTimeFormat(style = "S-")
    private LocalDate lastEdit;

    protected Review() {
    }

    public Review(@NotNull long steamId, String review, @NotNull long thumbsUp, @NotNull long thumbsDown, @NotNull LocalDate lastEdit) {
        this.steamId = steamId;
        this.review = review;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.lastEdit = lastEdit;
    }

    public Review(long id, @NotNull long steamId, String review, @NotNull long thumbsUp, @NotNull long thumbsDown, @NotNull LocalDate lastEdit) {
        this.id = id;
        this.steamId = steamId;
        this.review = review;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.lastEdit = lastEdit;
    }

    public long getId() {
        return id;
    }
    public long getSteamId() {
        return steamId;
    }

    public String getReview() {
        return review;
    }

    public long getThumbsUp() {
        return thumbsUp;
    }

    public long getThumbsDown() {
        return thumbsDown;
    }

    public LocalDate getLastEdit() {return lastEdit;}

}
