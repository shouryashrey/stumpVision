package com.shouryashrey.crick_model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreUpdatePayload implements EventPayload {

    private int runs;

    private int wickets;

    private double overNumber;

    private int targetScore;

    @Override
    public EventType getEventType() {
        return EventType.SCORE_UPDATE;
    }
}
