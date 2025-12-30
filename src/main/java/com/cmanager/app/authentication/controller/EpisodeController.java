package com.cmanager.app.authentication.controller;

import com.cmanager.app.application.data.EpisodeDTO;
import com.cmanager.app.authentication.data.CreateEpisodeDTO;
import com.cmanager.app.authentication.domain.Episode;
import com.cmanager.app.authentication.service.EpisodeService;
import com.cmanager.app.core.exception.AlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public List<EpisodeDTO> findAll(Pageable pageable){
        return episodeService.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EpisodeDTO> create(@RequestBody CreateEpisodeDTO createEpisodeDTO) {
        // Cria a URI para o cabeçalho Location (ex: /api/episodes/1)
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createEpisodeDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(episodeService.createEpisode(createEpisodeDTO));
    }
}
