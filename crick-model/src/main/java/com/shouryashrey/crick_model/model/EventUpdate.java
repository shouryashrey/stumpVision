package com.shouryashrey.crick_model.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shouryashrey.crick_model.serializer.EventUpdateDeserializer;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@JsonDeserialize(using = EventUpdateDeserializer.class)
public class EventUpdate implements Serializable {

    private Long matchId;

    private EventType eventType;

    private Long eventTime;

    private String message;

    private EventPayload payload;
}
