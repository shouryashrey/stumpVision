package com.shouryashrey.crick_kafka_producer.controller;

import com.shouryashrey.crick_kafka_producer.service.EventPushService;
import com.shouryashrey.crick_model.model.EventUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventUpdateController {

    @Autowired
    private EventPushService eventPushService;

    @PostMapping("/push")
    public ResponseEntity<String> pushUpdates(@RequestBody EventUpdate eventUpdate) {
        eventPushService.pushEvents(eventUpdate);
        return ResponseEntity.ok("Event updates pushed successfully");
    }
}
