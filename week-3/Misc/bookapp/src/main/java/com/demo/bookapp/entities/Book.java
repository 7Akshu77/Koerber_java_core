package com.demo.bookapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{book.name.absent}")
    @Column(name="book_isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    @NotEmpty(message = "{book.title.absent}")
    @Column(name="book_title", nullable = false, length = 20)
    private String title;

    @NotEmpty(message = "{book.category.absent}")
    @Column(name="book_category", nullable = false, length = 20)
    private String category;

    @NotEmpty(message = "{book.author.absent}")
    @Column(name="book_author", nullable = false, length = 20)
    private String author;

    @NotNull(message = "{book.price.absent}")
    @Range(min = 100 , max = 10000, message = "{book.price.invalid}")
    @Column(name="book_price")
    private BigDecimal price;

    public Book( String isbn, String title, String category, String author, BigDecimal price) {

        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
        this.price = price;
    }
}