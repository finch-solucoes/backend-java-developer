package com.cmanager.app.authentication.repository;

import com.cmanager.app.authentication.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {

}
