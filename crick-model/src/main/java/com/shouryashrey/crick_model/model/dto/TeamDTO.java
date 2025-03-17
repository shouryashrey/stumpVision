package com.shouryashrey.crick_model.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    @NotBlank(message = "Team name is required")
    private String teamName;

    @NotBlank(message = "Short name is required")
    @Size(max = 10, message = "Short name should be less than 10 characters")
    private String shortName;

    private String country;
}
