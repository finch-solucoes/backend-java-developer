package com.cmanager.app.authentication.service;

import com.cmanager.app.application.data.EpisodeDTO;
import com.cmanager.app.authentication.data.CreateEpisodeDTO;
import com.cmanager.app.authentication.domain.Episode;
import com.cmanager.app.authentication.repository.EpisodeRepository;
import com.cmanager.app.core.exception.AlreadyExistsException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public EpisodeDTO createEpisode(CreateEpisodeDTO createEpisodeDTO) {
        Episode episode = episodeRepository.findById(createEpisodeDTO.id()).orElse(null);
        if (Objects.nonNull(episode)){
            throw new AlreadyExistsException("Episode", createEpisodeDTO.id());
        }
        episode = createEpisodeDTO.toEntity();

        return episodeRepository.save(episode).convertToDTO();
    }

    @Override
    public void deleteEpisode(String episodeId) {

    }

    @Override
    public EpisodeDTO findById(String episodeId) {
        return null;

    }

    @Override
    public void updateEpisode(EpisodeDTO episodeDTO) {

    }

    @Override
    public List<EpisodeDTO> findAll(Pageable pageable) {
        return episodeRepository.findAll(pageable).map(Episode::convertToDTO).toList();
    }
}
