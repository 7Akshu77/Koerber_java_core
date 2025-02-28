package org.example.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;

    //getter setter , ctr
}

