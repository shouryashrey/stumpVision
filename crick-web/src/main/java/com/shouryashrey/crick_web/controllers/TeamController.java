package com.shouryashrey.crick_web.controllers;

import com.shouryashrey.crick_model.model.CustomResponse;
import com.shouryashrey.crick_model.model.Team;
import com.shouryashrey.crick_model.model.dto.TeamDTO;
import com.shouryashrey.crick_service.services.impl.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<CustomResponse> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO savedTeam = teamService.saveTeam(teamDTO);
        return ResponseEntity.ok(new CustomResponse("success", String.format("Team %s created successfully", savedTeam.getTeamName())));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }
}
