package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    private JournalEntryRepo journalEntryRepo;

    @Autowired
    public JournalServiceImpl(JournalEntryRepo journalEntryRepo) {
        this.journalEntryRepo = journalEntryRepo;
    }

    @Override
    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    @Override
    public JournalEntry addJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepo.save(journalEntry);
    }

    @Override
    public JournalEntry updateJournalEntry(String id , JournalEntry journalEntry) {
        JournalEntry je1 = journalEntryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("JournalEntry not found"));
        je1.setTitle(journalEntry.getTitle());
        je1.setContent(journalEntry.getContent());
        je1.setDate(journalEntry.getDate());
        return journalEntryRepo.save(je1);

    }

    @Override
    public void deleteJournalEntry(String journalEntryId) {
        journalEntryRepo.deleteById(journalEntryId);
    }

    @Override
    public JournalEntry findByTitle(String title){
        return journalEntryRepo.findByName(title);
    }
}
