package com.demo.controller;

import com.demo.dao.Account;
import com.demo.dto.Transfer;
import com.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController

public class AccountController {
    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Transfer dto) {
       service.transfer(dto.getFromId(), dto.getToId(), dto.getAmount());
        return new ResponseEntity<>("transfer successful", HttpStatus.OK);
    }
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(service.getAllAccount(), HttpStatus.OK);
    }
    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        return new ResponseEntity<>(service.getAccount(id), HttpStatus.OK);
    }
    @PutMapping("/deposit/{id}")
    public ResponseEntity<String> deposit(@PathVariable int id, @RequestBody Account account) {
        BigDecimal amount = account.getBalance();
        service.deposit(id, amount);
        return new ResponseEntity<>("Deposit successful", HttpStatus.OK);
    }
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<String> withdraw(@PathVariable int id, @RequestBody Account account) {
        BigDecimal amount = account.getBalance();
        service.withdraw(id, amount);
        return new ResponseEntity<>("Withdraw successful", HttpStatus.OK);
    }

}
