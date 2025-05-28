package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_kafka.kafka.KafkaPublisher;
import com.shouryashrey.crick_model.model.EventUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventPublisherService {

    @Autowired
    private KafkaPublisher<String, EventUpdate> kafkaPublisher;

    public void pushEvents(EventUpdate event) {
        try {
            kafkaPublisher.pushUpdates("event-update", "event-update", event);
            log.info("Event updates pushed successfully");
        } catch (Exception e) {
            log.error("Error pushing event updates to Kafka topic");
            throw new RuntimeException(e);
        }
    }
}
