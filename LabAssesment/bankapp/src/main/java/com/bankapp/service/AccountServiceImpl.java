package com.bankapp.service;

import com.bankapp.entity.Bank;
import com.bankapp.exception.AccountNotFound;
import com.bankapp.logapp.Loggable;
import com.bankapp.repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BankService{
    private BankRepo bankRepo;

    @Autowired
    public BookServiceImpl(BankRepo bankRepo) {
        this.bankRepo = bankRepo;
    }

    @Override
    public Bank findById(int id) throws AccountNotFound {
        return bankRepo.findById(id)
                .orElseThrow(() -> new AccountNotFound("account not found"));

    @Override
    public void transfer(int from, int to, int amout) {
        Bank fromBank = bankRepo.findById(from).get();
        Bank toBank = bankRepo.findById(to).get();
        fromBank.setBalance(fromBank.getBalance() - amout);
        toBank.setBalance(toBank.getBalance() + amout);
        bankRepo.save(fromBank);
        bankRepo.save(toBank);

    }

    @Override
    public void deposit(int id, double amount) {

    }

    @Override
    public Bank getAccount(int id) {
        return null;
    }
}
