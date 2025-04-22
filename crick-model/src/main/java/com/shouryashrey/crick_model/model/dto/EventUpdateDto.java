package com.shouryashrey.crick_model.model.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.shouryashrey.crick_model.model.EventPayload;
import com.shouryashrey.crick_model.model.EventType;
import com.shouryashrey.crick_model.serializer.EventUpdateDeserializer;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonDeserialize
public class EventUpdateDto {

    private Long matchId;

    private EventType eventType;

    private LocalDateTime eventTime;

    private String message;

    private EventPayload payload;
}
