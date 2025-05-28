package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_dao.repos.TeamRepository;
import com.shouryashrey.crick_model.mapper.TeamMapper;
import com.shouryashrey.crick_model.model.Team;
import com.shouryashrey.crick_model.model.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    @CacheEvict(value = "teams", allEntries = true)
    public Team saveTeam(TeamDTO teamDTO) {
        Team team = TeamMapper.toEntity(teamDTO);
        return teamRepository.save(team);
    }

    @Cacheable(value="teams")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
