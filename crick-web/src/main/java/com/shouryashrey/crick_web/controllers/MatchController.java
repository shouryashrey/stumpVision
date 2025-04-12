package com.shouryashrey.crick_web.controllers;

import com.shouryashrey.crick_model.model.CricketMatchDetail;
import com.shouryashrey.crick_model.model.dto.CricketMatchDto;
import com.shouryashrey.crick_service.services.impl.CricketMatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private CricketMatchService cricketMatchService;

    @PostMapping("/create")
    public ResponseEntity<CricketMatchDetail> createMatch(@Valid @RequestBody CricketMatchDto cricketMatchDto) {
        CricketMatchDetail cricketMatch =  cricketMatchService.createCricketMatch(cricketMatchDto);
        return ResponseEntity.ok(cricketMatch);
    }
}
