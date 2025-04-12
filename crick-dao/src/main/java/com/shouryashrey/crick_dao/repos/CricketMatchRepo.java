package com.shouryashrey.crick_dao.repos;

import com.shouryashrey.crick_model.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketMatchRepo extends JpaRepository<CricketMatch, Long> {
}
