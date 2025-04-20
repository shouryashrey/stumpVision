package com.shouryashrey.crick_model.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CommentaryPayload.class, name = "COMMENTARY"),
        @JsonSubTypes.Type(value = MilestonePayload.class, name = "MILESTONE"),
        @JsonSubTypes.Type(value = RunEventPayload.class, name = "RUN"),
        @JsonSubTypes.Type(value = ScoreUpdatePayload.class, name = "SCORE_UPDATE"),
        @JsonSubTypes.Type(value = WicketEventPayload.class, name = "WICKET"),
        @JsonSubTypes.Type(value = MilestonePayload.class, name = "MATCH_START"),
        @JsonSubTypes.Type(value = MilestonePayload.class, name = "MATCH_END"),
        @JsonSubTypes.Type(value = MilestonePayload.class, name = "END_INNINGS"),
        @JsonSubTypes.Type(value = MilestonePayload.class, name = "END_MATCH"),
})
public interface EventPayload {
    EventType getEventType();
}
