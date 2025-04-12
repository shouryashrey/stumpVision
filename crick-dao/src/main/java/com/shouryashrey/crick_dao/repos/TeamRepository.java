package com.shouryashrey.crick_dao.repos;

import com.shouryashrey.crick_model.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByTeamName(String teamName);
    boolean existsByTeamName(String teamName);
    boolean existsByShortName(String shortName);
}
