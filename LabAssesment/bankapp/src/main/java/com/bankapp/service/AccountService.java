package com.bankapp.service;

import com.bankapp.dto.TransferDto;
import com.bankapp.entity.Bank;
import com.bankapp.exception.AccountNotFound;

import java.util.List;

public interface BankService {
    public void transfer(int from, int to, int amout);
    public void deposit(int id, double amount);
    public Bank getAccount(int id);
    public Bank findById(int id) throws AccountNotFound;
}
