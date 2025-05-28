package com.shouryashrey.crick_model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.shouryashrey.crick_model.model.*;

import java.io.IOException;

public class EventUpdateDeserializer extends StdDeserializer<EventUpdate> {

    public EventUpdateDeserializer() {
        super(EventUpdate.class);
    }

    @Override
    public EventUpdate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        Long matchId = node.get("matchId").asLong();
        EventType eventType = EventType.valueOf(node.get("eventType").asText());
        String message = node.get("message").asText();
        Long timeStamp = node.get("eventTime").asLong();

        JsonNode payloadNode = node.get("payload");

        EventPayload payload = switch (eventType) {
            case RUN -> codec.treeToValue(payloadNode, RunEventPayload.class);
            case WICKET -> codec.treeToValue(payloadNode, WicketEventPayload.class);
            case SCORE_UPDATE -> codec.treeToValue(payloadNode, ScoreUpdatePayload.class);
            case COMMENTARY -> codec.treeToValue(payloadNode, CommentaryPayload.class);
            default -> codec.treeToValue(payloadNode, MilestonePayload.class);
        };

        return EventUpdate.builder()
                .matchId(matchId)
                .eventType(eventType)
                .eventTime(timeStamp)
                .message(message)
                .payload(payload)
                .build();
    }
}
