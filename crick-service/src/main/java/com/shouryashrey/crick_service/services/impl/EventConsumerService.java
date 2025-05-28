package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_dao.repos.CricketMatchRepo;
import com.shouryashrey.crick_model.model.CommentaryPayload;
import com.shouryashrey.crick_model.model.CricketMatch;
import com.shouryashrey.crick_model.model.EventUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EventConsumerService {

    @Autowired
    private CricketMatchRepo cricketMatchRepo;

    @Autowired
    private CricketMatchService cricketMatchService;

    public void consumeEvents(EventUpdate event) {
        Optional<CricketMatch> match = cricketMatchService.getMatchInfoById(event.getMatchId());
        if(match.isEmpty()) {
            log.warn("Invalid matchID: {}", event.getMatchId());
            return;
        }

        switch (event.getEventType()) {
            case MATCH_START -> {
                cricketMatchRepo.updateMatchStartTime(event.getMatchId(), event.getEventTime());
                log.info("Match started at {}", event.getEventTime());
            }
            case MATCH_END -> {
                cricketMatchRepo.updateMatchEndTime(event.getMatchId(), event.getEventTime());
                log.info("Match ended at {}", event.getEventTime());
            }
            case COMMENTARY -> {
                CommentaryPayload commentary = (CommentaryPayload) event.getPayload();
                if (commentary != null) {
                    log.info("Commentary: {}", commentary.getCommentary());
                }
            }
        }
    }
}
