package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JournalService {
    List<JournalEntry> getAll();
    JournalEntry addJournalEntry(JournalEntry journalEntry);
    JournalEntry updateJournalEntry(String id, JournalEntry journalEntry);
    void deleteJournalEntry(String journalEntryId);
    public JournalEntry findByTitle(String title);
}
