package com.duaa.moodtracker.repository;

import com.duaa.moodtracker.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {

    List<MoodEntry> findByDateBetween(LocalDate from, LocalDate to);

    @Query("SELECT m FROM MoodEntry m JOIN m.tags t WHERE t = :tag")
    List<MoodEntry> findByTag(String tag);
}
