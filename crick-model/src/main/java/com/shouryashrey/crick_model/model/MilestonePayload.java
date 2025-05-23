package com.shouryashrey.crick_model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MilestonePayload implements EventPayload {

    private String milestoneType;

    private String milestoneMessage;

    private EventType eventType; // Add this to identify the specific milestone

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
