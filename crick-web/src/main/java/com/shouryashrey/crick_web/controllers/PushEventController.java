package com.shouryashrey.crick_web.controllers;

import com.shouryashrey.crick_model.model.EventUpdate;
import com.shouryashrey.crick_service.services.impl.EventPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class PushEventController {

    @Autowired
    private EventPublisherService eventPublisherService;

    @PostMapping("/push")
    public ResponseEntity<String> pushUpdates(@RequestBody EventUpdate eventUpdate) {
        eventPublisherService.pushEvents(eventUpdate);
        return ResponseEntity.ok("Event updates pushed successfully");
    }
}
