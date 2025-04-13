package com.duaa.moodtracker.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record MoodEntryDto(

        @Min(1) @Max(10)
        @NotNull
        @Schema(description = "Mood score from 1 to 10", example = "7")
        Integer moodScore,

        @Min(1) @Max(10)
        @NotNull
        @Schema(description = "Stress level from 1 to 10", example = "3")
        Integer stressLevel,

        @Size(max = 500)
        @Schema(description = "Optional notes about the mood", example = "Felt much better after journaling")
        String notes,

        @Size(max = 10)
        @Schema(description = "Tags related to the mood", example = "[\"sleep\", \"work\"]")
        List<@NotBlank String> tags

) {}