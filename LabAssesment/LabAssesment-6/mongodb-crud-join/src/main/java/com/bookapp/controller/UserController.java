package com.bookapp.controller;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.service.JournalService;
import com.bookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JournalService journalEntryService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }
    // Add a new user
    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    // Get a user by username
    @GetMapping("users/{userName}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String userName) {
        return ResponseEntity.ok().body(userService.getUserByName(userName));
    }

    // Add a journal entry to a user
    @PutMapping("/{userName}/addJournal/{journalEntryId}")
    public ResponseEntity<User> addJournalEntry(@PathVariable String userName, @PathVariable String journalEntryId) {
        return ResponseEntity.ok().body(userService.addJournalEntryToUser(userName, journalEntryId));
    }

    // Update a user's name
    @PutMapping("/{oldName}/updateName/{newName}")
    public ResponseEntity<User> updateUserName(@PathVariable String oldName, @PathVariable String newName) {
        return ResponseEntity.ok(userService.updateUserName(oldName, newName));
    }

    // Remove a journal entry from a user
    @DeleteMapping("/{userName}/removeJournal/{journalEntryId}")
    public ResponseEntity<User> removeJournalEntry(@PathVariable String userName, @PathVariable String journalEntryId) {
        return ResponseEntity.ok().body(userService.removeJournalEntry(userName, journalEntryId));
    }

    // 6️⃣ Delete a user
    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteUserById(id);
    }
    // get all Journal
    @GetMapping("journal")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.ok(journalEntryService.getAll());
    }

    @GetMapping("journal/{title}")
    public ResponseEntity<JournalEntry> findByName(@PathVariable String title) {
        return ResponseEntity.ok().body(journalEntryService.findByTitle(title));
    }

    // add journal
    @PostMapping("journal")
    public ResponseEntity<JournalEntry> addJournalEntry(@RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok().body(journalEntryService.addJournalEntry(journalEntry));
    }

    // update Journal
    @PutMapping("journal/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable String id, @RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok().body(journalEntryService.updateJournalEntry(id, journalEntry));
    }

    // delete Journal
    @DeleteMapping("journal/{id}")
    public void deleteJournalEntry(@PathVariable String id) {
        journalEntryService.deleteJournalEntry(id);
    }

}
