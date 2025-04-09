package com.shouryashrey.crick_model.mapper;

import com.shouryashrey.crick_model.model.CricketMatch;
import com.shouryashrey.crick_model.model.dto.CricketMatchDto;

public class CricketMatchMapper {

    public static CricketMatch toEntity(CricketMatchDto cricketMatchDTO) {
        return CricketMatch.builder()
                .matchType(cricketMatchDTO.getMatchType())
                .seriesName(cricketMatchDTO.getSeriesName())
                .matchDate(cricketMatchDTO.getMatchDate())
                .venue(cricketMatchDTO.getVenue())
                .teamAId(cricketMatchDTO.getTeamAId())
                .teamBId(cricketMatchDTO.getTeamBId())
                .overs(cricketMatchDTO.getOvers())
                .build();
    }

    public static CricketMatchDto toDto(CricketMatch cricketMatch) {
        return CricketMatchDto.builder()
                .matchType(cricketMatch.getMatchType())
                .seriesName(cricketMatch.getSeriesName())
                .matchDate(cricketMatch.getMatchDate())
                .venue(cricketMatch.getVenue())
                .build();
    }
}
