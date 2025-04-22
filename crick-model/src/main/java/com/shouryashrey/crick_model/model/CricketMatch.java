package com.shouryashrey.crick_model.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cricket_match")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CricketMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matchType;

    private String seriesName;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    private String venue;

    @Column(name = "team_a_id", nullable = false)
    private Long teamAId;

    @Column(name = "team_b_id", nullable = false)
    private Long teamBId;

    private Integer overs;

    private LocalDateTime matchStartTime;

    private LocalDateTime matchEndTime;
}
