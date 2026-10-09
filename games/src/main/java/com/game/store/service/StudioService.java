package com.game.store.service;

import com.game.store.model.entity.Studio;
import com.game.store.repository.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudioService {

    private final StudioRepository studioRepository;

    public List<Studio> getAll(){
        return studioRepository.findAll();
    }

    public Studio createStudio(Studio studio) {
        return studioRepository.save(studio);
    }
}
