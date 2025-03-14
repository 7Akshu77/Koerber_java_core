package com.demo.service;

import com.demo.exception.AccountNotFound;
import com.demo.dao.Account;
import com.demo.logapp.Loggable;
import com.demo.repo.AccountRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo repo;

    @Autowired
    public AccountServiceImpl(AccountRepo repo) {
        this.repo = repo;
    }
    @Loggable
    @Transactional
    @Override
    public void transfer(int from, int to, BigDecimal amount) {
        Account fromAccount = repo.findById(from).get();
        Account toAccount = repo.findById(to).get();
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        repo.save(fromAccount);
        repo.save(toAccount);
    }

    @Override
    public List<Account> getAllAccount() {
        return repo.findAll().stream().toList();
    }

    @Transactional
    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account = repo.findById(id).get();
        account.setBalance(account.getBalance().add(amount));
        repo.save(account);
    }


    @Override
    public Account getAccount(int id) throws AccountNotFound {

        return repo.findById(id).orElseThrow(() -> new AccountNotFound("account not found"));
    }

    @Transactional
    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account = repo.findById(id).get();
        account.setBalance(account.getBalance().subtract(amount));
        repo.save(account);
    }
}
