package com.bankapp.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_table")
public class Bank {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{bank.name.absent}")
    @Column(name="name", nullable = false, unique = true, length = 30)
    private String name;

    @Range(min =0 , max = 100000, message = "Balance should be between 0 and 100000")
   private double balance;

    public Bank( String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}
