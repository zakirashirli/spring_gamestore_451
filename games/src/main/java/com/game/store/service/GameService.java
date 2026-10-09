package com.game.store.service;


import com.game.store.model.dto.game.GameRequest;
import com.game.store.model.dto.game.GameResponse;
import com.game.store.model.entity.Game;
import com.game.store.model.entity.Studio;
import com.game.store.repository.GameRepository;
import com.game.store.repository.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final StudioRepository studioRepository;

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public GameResponse createGame(GameRequest gameRequest) {

        Studio studio = studioRepository.findById(gameRequest.getStudioId())
                .orElseThrow(() -> new RuntimeException("no studio found"));

        Game game = new Game();

        game.setTitle(gameRequest.getTitle());
        game.setGenre(gameRequest.getGenre());
        game.setPrice(gameRequest.getPrice());
        game.setStudio(studio);

        Game savedGame = gameRepository.save(game);

        return convertToResponse(savedGame);
    }

    public GameResponse updateGame(Long id, GameRequest gameRequest) {

        Game game = gameRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("No game found"));

        Studio studio = studioRepository.findById(gameRequest.getStudioId())
                .orElseThrow(() -> new RuntimeException("No studio found"));

        game.setTitle(gameRequest.getTitle());
        game.setGenre(gameRequest.getGenre());
        game.setPrice(gameRequest.getPrice());
        game.setStudio(studio);

        Game updatedGame = gameRepository.save(game);

        return convertToResponse(updatedGame);
    }


    // Entity -> Response DTO
    private GameResponse convertToResponse(Game game) {
        return new GameResponse(
                game.getId(),
                game.getTitle(),
                game.getGenre(),
                game.getPrice(),
                game.getStudio().getName()
        );
    }
}
