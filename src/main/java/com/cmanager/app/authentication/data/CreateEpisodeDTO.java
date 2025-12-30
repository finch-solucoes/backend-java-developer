package com.cmanager.app.authentication.data;

import com.cmanager.app.authentication.domain.Episode;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateEpisodeDTO", description = "Dados para criação de um novo episódio")
public record CreateEpisodeDTO(
        @Schema(description = "ID do episódio", example = "1")
        String id,
        @Schema(description = "Nome do episódio", example = "Pilot")
        String name,
        @Schema(description = "Número da temporada", example = "1")
        Integer season,
        @Schema(description = "Número do episódio", example = "1")
        Integer number
) {
    public Episode toEntity() {
        return new Episode(id, name, season, number);
    }
}
