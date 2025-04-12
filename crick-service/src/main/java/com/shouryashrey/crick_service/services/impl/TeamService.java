package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_dao.repos.TeamRepository;
import com.shouryashrey.crick_model.mapper.TeamMapper;
import com.shouryashrey.crick_model.model.Team;
import com.shouryashrey.crick_model.model.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public TeamDTO saveTeam(TeamDTO teamDTO) {
        Team team = TeamMapper.toEntity(teamDTO);
        Team savedTeam = teamRepository.save(team);
        return TeamMapper.toDTO(savedTeam);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
