package com.shouryashrey.crick_model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RunEventPayload implements EventPayload {

    private int runs;

    private double overNumber;

    @Override
    public EventType getEventType() {
        return EventType.RUN;
    }
}
