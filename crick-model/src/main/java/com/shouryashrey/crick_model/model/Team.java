package com.shouryashrey.crick_model.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "team")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String teamName;

    @Column(nullable = false, unique = true)
    private String shortName;

    private String country;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Team(String teamName, String shortName, String country) {
        this.teamName = teamName;
        this.shortName = shortName;
        this.country = country;
    }
}
