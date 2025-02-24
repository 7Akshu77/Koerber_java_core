package com.bookapp.service;

import com.bookapp.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAll();
    public User addUser(User user);
    public Optional<User> getUserByName(String userName);
    public User addJournalEntryToUser(String userName, String journalEntryId);
    public User updateUserName(String oldName, String newName);
    public User removeJournalEntry(String userName, String journalEntryId);
    public void deleteUser(String userName);
    public void deleteUserById(String id);

}
