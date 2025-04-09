package com.shouryashrey.crick_web.controllers;

import com.shouryashrey.crick_model.model.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @PostMapping("/create")
    public ResponseEntity<CustomResponse> createMatch() {
        return ResponseEntity.ok(new CustomResponse("success", "Match created successfully"));
    }
}
