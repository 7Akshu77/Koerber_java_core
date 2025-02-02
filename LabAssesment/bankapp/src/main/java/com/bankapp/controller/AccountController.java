package com.bankapp.controller;

import com.bankapp.dto.TransferDto;
import com.bankapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BankController {

    @Autowired
    private InfoDto infoDto;

    BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
    @GetMapping
    public ResponseEntity<List<TransferDto>> getAllBanks() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bankService.findAllBanks());
    }
    @GetMapping("bank/balance/{id}")
    public ResponseEntity<Double> getBalance(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(bankService.getBalance(id));
    }

    @GetMapping(path = "bank/{id}")
    public ResponseEntity<TransferDto> getBank(@PathVariable int id) {
        return ResponseEntity.ok().body(bankService.getBank(id));
    }
    @PostMapping(path = "transfer")
    public ResponseEntity<Void> transfer( int from,  int  to, double amount) {
        bankService.transfer(from, to, amount);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping(path = "contact-info")
    public InfoDto getInfo(){
        return  infoDto;
    }

}
