package com.shouryashrey.crick_model.mapper;

import com.shouryashrey.crick_model.model.Team;
import com.shouryashrey.crick_model.model.dto.TeamDTO;

import java.time.LocalDateTime;

public class TeamMapper {

    public static Team toEntity(TeamDTO teamDTO) {
        return Team.builder()
                .teamName(teamDTO.getTeamName())
                .shortName(teamDTO.getShortName())
                .country(teamDTO.getCountry())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static TeamDTO toDTO(Team team) {
        return TeamDTO.builder()
                .teamName(team.getTeamName())
                .shortName(team.getShortName())
                .country(team.getCountry())
                .build();
    }
}
