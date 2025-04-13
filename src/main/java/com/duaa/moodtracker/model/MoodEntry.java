package com.duaa.moodtracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int moodScore;      // Scale: 1–10
    private int stressLevel;    // Scale: 1–10
    private String notes;

    @ElementCollection
    private List<String> tags;  // e.g., ["work", "sleep", "anxiety"]

}
