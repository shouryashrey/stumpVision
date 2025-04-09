package com.shouryashrey.crick_model.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CricketMatchDto {

    private String matchType;

    private String seriesName;

    private LocalDateTime matchDate;

    private String venue;

    private  Long teamAId;

    private Long teamBId;

    private Integer overs;
}
