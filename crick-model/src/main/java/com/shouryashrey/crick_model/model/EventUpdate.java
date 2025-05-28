package com.shouryashrey.crick_model.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shouryashrey.crick_model.serializer.EventUpdateDeserializer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "matchId can't be null")
    @Min(value = 1, message = "matchId must be greater than 0")
    private Long matchId;

    @NotNull(message = "eventType can't be null")
    private EventType eventType;

    @NotNull(message = "Event time cannot be null")
    @Min(value = 1, message = "Event time must be greater than 0")
    private Long eventTime;

    private String message;

    private EventPayload payload;
}
