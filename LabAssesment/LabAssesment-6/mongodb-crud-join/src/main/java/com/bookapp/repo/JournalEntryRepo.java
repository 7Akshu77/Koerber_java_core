package com.bookapp.repo;

import com.bookapp.entities.JournalEntry;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepo extends MongoRepository<JournalEntry, String> {
    @Query("{'title': ?0}")
    public JournalEntry findByName(String name);
}
