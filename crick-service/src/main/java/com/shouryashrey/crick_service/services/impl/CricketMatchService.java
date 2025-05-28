package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_dao.repos.CricketMatchRepo;
import com.shouryashrey.crick_dao.repos.TeamRepository;
import com.shouryashrey.crick_model.mapper.CricketMatchMapper;
import com.shouryashrey.crick_model.model.CricketMatch;
import com.shouryashrey.crick_model.model.CricketMatchDetail;
import com.shouryashrey.crick_model.model.Team;
import com.shouryashrey.crick_model.model.dto.CricketMatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CricketMatchService {

    @Autowired
    private CricketMatchRepo cricketMatchRepo;

    @Autowired
    private TeamRepository teamRepository;

    public CricketMatchDetail createCricketMatch(CricketMatchDto cricketMatchDto) {
        CricketMatch cricketMatch = CricketMatchMapper.toEntity(cricketMatchDto);
        Optional<Team> teamA = teamRepository.findById(cricketMatchDto.getTeamAId());
        Optional<Team> teamB = teamRepository.findById(cricketMatchDto.getTeamBId());

        if(teamA.isEmpty() || teamB.isEmpty()) {
            throw new IllegalArgumentException("One or both teams do not exist");
        }

        cricketMatchRepo.save(cricketMatch);

        return new CricketMatchDetail(cricketMatch, teamA.get(), teamB.get());
    }

    @Cacheable(value = "cricketMatch", key = "#matchId", unless = "#result == null || #result.isEmpty()")
    public Optional<CricketMatch> getMatchInfoById(Long matchId) {
        return cricketMatchRepo.findById(matchId);
    }
}
