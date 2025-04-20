package com.shouryashrey.crick_web.kafka;

import com.shouryashrey.crick_model.model.EventUpdate;
import com.shouryashrey.crick_service.services.impl.EventConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @Autowired
    EventConsumerService eventConsumer;

    @KafkaListener(topics = "event-update", groupId = "crick-consumer-group")
    public void consumeEvents(EventUpdate event) {
        log.info(String.format("Event received: %s", event.getMessage()));
        eventConsumer.consumeEvents(event);
    }
}
