package com.shouryashrey.crick_model.model;

import lombok.Getter;

@Getter
public enum EventType {
    RUN,
    WICKET,
    NO_BALL,
    WIDE,
    BYE,
    LEG_BYE,
    FOUR,
    SIX,
    OUT,
    END_INNINGS,
    END_MATCH,
    MATCH_START,
    MATCH_END,
    SCORE_UPDATE,
    MILESTONE,
    COMMENTARY
}
