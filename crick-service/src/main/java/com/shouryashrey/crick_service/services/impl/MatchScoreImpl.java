package com.shouryashrey.crick_service.services.impl;

import com.shouryashrey.crick_service.services.MatchScore;
import org.springframework.stereotype.Service;

@Service
public class MatchScoreImpl implements MatchScore {

    @Override
    public int getCurrentScore() {
        return 123;
    }
}
