package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, JournalEntryRepo journalEntryRepo) {
        this.userRepo = userRepo;
        this.journalEntryRepo = journalEntryRepo;
    }

    @Autowired
    public List<User> getAll(){
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public User addJournalEntryToUser(String userName, String journalEntryId) {
        Optional<User> userOpt = userRepo.findByUserName(userName);
        Optional<JournalEntry> journalOpt = journalEntryRepo.findById(journalEntryId);

        if (userOpt.isPresent() && journalOpt.isPresent()) {
            User user = userOpt.get();
            user.getJournalEntries().add(journalOpt.get());
            return userRepo.save(user);
        }

        return null;
    }

    @Override
    public User updateUserName(String oldName, String newName) {
        Optional<User> userOpt = userRepo.findByUserName(oldName);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUserName(newName);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public User removeJournalEntry(String userName, String journalEntryId) {
        Optional<User> userOpt = userRepo.findByUserName(userName);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.getJournalEntries().removeIf(entry -> entry.getId().equals(journalEntryId));
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String userName) {
        userRepo.findByUserName(userName).ifPresent(userRepo::delete);
    }
    @Override
    public void deleteUserById(String id){
        userRepo.findById(id).ifPresent(userRepo::delete);
    }
}
