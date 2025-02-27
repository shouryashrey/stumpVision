package com.shouryashrey.crick_web.controllers;

import com.shouryashrey.crick_service.services.impl.MatchScoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchScoreImpl matchService;

    @GetMapping("/score")
    public ResponseEntity<Integer> getMatchScore() {
        try {
            int currentScore = matchService.getCurrentScore();
            return ResponseEntity.ok(currentScore);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
