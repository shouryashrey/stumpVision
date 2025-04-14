package com.shouryashrey.crick_kafka.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaPublisher(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void pushUpdates(String topic, K key, V value) {
        kafkaTemplate.send(topic, key, value);
    }
}
