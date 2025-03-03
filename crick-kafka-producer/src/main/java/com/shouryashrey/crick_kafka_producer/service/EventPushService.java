package com.shouryashrey.crick_kafka_producer.service;

import com.shouryashrey.crick_kafka_producer.kafka.KafkaPublisher;
import com.shouryashrey.crick_model.model.EventUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventPushService {

    @Autowired
    private KafkaPublisher<String, EventUpdate> kafkaPublisher;

    public void pushEvents(EventUpdate eventUpdate) {
        try {
            kafkaPublisher.pushUpdates("event-update", "event-update", eventUpdate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
