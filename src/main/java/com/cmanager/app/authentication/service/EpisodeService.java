package com.cmanager.app.authentication.service;

import com.cmanager.app.application.data.EpisodeDTO;
import com.cmanager.app.authentication.data.CreateEpisodeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EpisodeService {

    public EpisodeDTO createEpisode(CreateEpisodeDTO createEpisodeDTO);

    public void deleteEpisode(String episodeId);

    public EpisodeDTO findById(String episodeId);

    public void updateEpisode(EpisodeDTO episodeDTO);

    public List<EpisodeDTO> findAll(Pageable pageable);

}
