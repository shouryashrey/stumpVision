package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_dao.repos.CricketMatchRepo;
import com.shouryashrey.crick_model.model.EventUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventConsumerService {

    @Autowired
    private CricketMatchRepo cricketMatchRepo;

    public void consumeEvents(EventUpdate event) {
        // TODO: check if the cricket match exist or not and store the match details in cache with the ttl set to match estimated end time.
        switch (event.getEventType()) {
            case MATCH_START -> {
                cricketMatchRepo.updateMatchStartTime(event.getMatchId(), event.getEventTime());
                log.info("Match started at {}", event.getEventTime());
            }
            case MATCH_END -> {
                cricketMatchRepo.updateMatchEndTime(event.getMatchId(), event.getEventTime());
                log.info("Match ended at {}", event.getEventTime());
            }
            case RUN -> {

            }
        }
    }
}
