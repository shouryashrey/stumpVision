package com.shouryashrey.crick_dao.repos;

import com.shouryashrey.crick_model.model.CricketMatch;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.function.Function;

@Repository
public interface CricketMatchRepo extends JpaRepository<CricketMatch, Long> {

    @Modifying
    @Transactional
    @Query("update CricketMatch cm set cm.matchStartTime = :startTime where cm.id = :matchId")
    void updateMatchStartTime(Long matchId, Long startTime);

    @Modifying
    @Transactional
    @Query("update CricketMatch cm set cm.matchEndTime = :endTime where cm.id = :matchId")
    void updateMatchEndTime(Long matchId, Long endTime);
}
