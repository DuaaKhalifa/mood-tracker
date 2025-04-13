package com.duaa.moodtracker.service;

import com.duaa.moodtracker.model.MoodEntry;
import com.duaa.moodtracker.repository.MoodEntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoodEntryService {

    private final MoodEntryRepository repository;

    public MoodEntryService(MoodEntryRepository repository) {
        this.repository = repository;
    }

    public MoodEntry save(MoodEntry entry) {
        return repository.save(entry);
    }

    public List<MoodEntry> getAllFiltered(LocalDate from, LocalDate to, String tag) {
        List<MoodEntry> entries = repository.findAll();

        if (from != null && to != null) {
            entries = entries.stream()
                    .filter(e -> !e.getDate().isBefore(from) && !e.getDate().isAfter(to))
                    .collect(Collectors.toList());
        }

        if (tag != null && !tag.isEmpty()) {
            entries = entries.stream()
                    .filter(e -> e.getTags() != null && e.getTags().contains(tag))
                    .collect(Collectors.toList());
        }

        return entries;
    }

}
