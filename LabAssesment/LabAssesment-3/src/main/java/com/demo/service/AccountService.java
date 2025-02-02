package com.demo.service;

import com.demo.exception.AccountNotFound;
import com.demo.dao.Account;
import com.demo.dto.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public List<Account> getAllAccount();
    public void transfer(int from, int to, BigDecimal amount);
    public void deposit(int id, BigDecimal amount);
    public Account getAccount(int id)  throws AccountNotFound;
    public void withdraw(int id, BigDecimal amount);


}
