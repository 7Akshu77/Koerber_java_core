package com.demo.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{name.absent}")
    private String name;

    @Range(min = 0 , max = 1000000, message = "{balance.invalid}")
    private BigDecimal balance;

    public Account(String name, BigDecimal amount) {
        this.name = name;
        this.balance = amount;
    }
}
