package com.shouryashrey.crick_model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentaryPayload implements EventPayload {

    private String commentary;


    @Override
    public EventType getEventType() {
        return EventType.COMMENTARY;
    }
}
