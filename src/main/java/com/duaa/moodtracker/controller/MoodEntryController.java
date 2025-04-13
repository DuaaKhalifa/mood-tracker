package com.duaa.moodtracker.controller;

import com.duaa.moodtracker.dto.MoodEntryDto;
import com.duaa.moodtracker.model.MoodEntry;
import com.duaa.moodtracker.service.MoodEntryService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Mood Entries", description = "Manage user's mood entry data")
@RestController
@RequestMapping("/api/mood-entries")
public class MoodEntryController {

    private final MoodEntryService service;

    public MoodEntryController(MoodEntryService service) {
        this.service = service;
    }

    @Operation(summary = "Add a new mood entry", description = "Create and save a new mood entry with mood score, stress level, notes, and tags.")
    @PostMapping
    public ResponseEntity<MoodEntry> addEntry(@RequestBody @Valid MoodEntryDto dto) {
        MoodEntry entry = new MoodEntry();
        entry.setDate(LocalDate.now());
        entry.setMoodScore(dto.moodScore());
        entry.setStressLevel(dto.stressLevel());
        entry.setNotes(dto.notes());
        entry.setTags(dto.tags());

        return ResponseEntity.ok(service.save(entry));
    }

    @Operation(summary = "Get mood entries", description = "Fetch mood entries with optional date range and tag filtering.")
    @GetMapping
    public ResponseEntity<List<MoodEntry>> getEntries(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            @RequestParam(required = false) String tag) {

        List<MoodEntry> entries = service.getAllFiltered(fromDate, toDate, tag);
        return ResponseEntity.ok(entries);
    }

}
