package com.game.store.controller;

import com.game.store.model.dto.game.GameRequest;
import com.game.store.model.dto.game.GameResponse;
import com.game.store.model.entity.Game;
import com.game.store.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/games")
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @PostMapping("/games")
    public GameResponse create(@RequestBody GameRequest gameRequest) {
        return gameService.createGame(gameRequest);
    }

    @PutMapping("/games/update/{id}")
    public GameResponse update(@PathVariable Long id, @RequestBody GameRequest gameRequest) {
        return gameService.updateGame(id, gameRequest);
    }
}
