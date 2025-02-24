package com.bookapp.repo;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByUserName(String userName);
}
