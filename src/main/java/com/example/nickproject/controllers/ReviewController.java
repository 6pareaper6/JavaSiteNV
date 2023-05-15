package com.example.nickproject.controllers;

import com.example.nickproject.domains.Game;
import com.example.nickproject.domains.Review;
import com.example.nickproject.services.GameService;
import com.example.nickproject.services.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/review")
//@ExposesResourceFor(Game.class)
//@CrossOrigin(exposedHeaders = "Location")
public class ReviewController {

    private final GameService gameService;
    private final ReviewService reviewService;

    //private final EntityLinks entityLinks;

    public ReviewController(GameService gameService, ReviewService reviewService) {
        this.gameService = gameService;
        this.reviewService = reviewService;
    }

    /*public ReviewController(GameService gameService, EntityLinks entityLinks) {
        this.gameService = gameService;
        this.entityLinks = entityLinks;
    }*/

    @GetMapping
    private ModelAndView gameIndex()
    {
        return new ModelAndView("gameIndex", "gameList", gameService.findAll());
    }

    @GetMapping("/{steamId}")
    private ModelAndView gameReview(@PathVariable long steamId)
    {
        return new ModelAndView("gameReview", "gameReview", reviewService.findBysteamId(steamId));
    }

    @GetMapping("game/add")
    private ModelAndView addGame()
    {
        return new ModelAndView("addGame").addObject(new Game(0,""));
    }

    @PostMapping
    public ModelAndView postGame(@Valid Game game, Errors errors)
    {
        gameService.create(game);
        return new ModelAndView("gameIndex", "gameList", gameService.findAll());
    }

    /*@GetMapping("getGames")
    CollectionModel<EntityModel<Game>> findAll()
    {
        return CollectionModel.of(
                gameService.findAll().stream()
                .map(game ->
                    EntityModel.of(game))
                .collect(Collectors.toList()));
    }*/

    /*@GetMapping("{id}")
    EntityModel<Game> get(@PathVariable long id)
    {
        return gameService.findById(id).map(game -> EntityModel.of(
                game)).orElseThrow();
    }*/



}
