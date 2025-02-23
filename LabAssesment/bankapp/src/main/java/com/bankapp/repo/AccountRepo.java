package com.bankapp.repo;

import com.bankapp.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {
}
