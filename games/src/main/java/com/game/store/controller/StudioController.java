package com.game.store.controller;

import com.game.store.model.entity.Studio;
import com.game.store.service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudioController {

    private final StudioService studioService;

    @GetMapping("/studios")
    public List<Studio> getAll() {
        return studioService.getAll();
    }

    @PostMapping("/studios")
    public Studio create(@RequestBody Studio studio) {
        return studioService.createStudio(studio);
    }
}
