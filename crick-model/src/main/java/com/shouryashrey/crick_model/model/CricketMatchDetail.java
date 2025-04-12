package com.shouryashrey.crick_model.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class CricketMatchDetail {

    private Long id;

    private String matchType;

    private String seriesName;

    private LocalDateTime matchDate;

    private String venue;

    private Team teamA;

    private Team teamB;

    private Integer overs;

    public CricketMatchDetail(CricketMatch cricketMatch, Team teamA, Team teamB) {
        this.id = cricketMatch.getId();
        this.matchType = cricketMatch.getMatchType();
        this.seriesName = cricketMatch.getSeriesName();
        this.matchDate = cricketMatch.getMatchDate();
        this.venue = cricketMatch.getVenue();
        this.teamA = teamA;
        this.teamB = teamB;
        this.overs = cricketMatch.getOvers();
    }

}
