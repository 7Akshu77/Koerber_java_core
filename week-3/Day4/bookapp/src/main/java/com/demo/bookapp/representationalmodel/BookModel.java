package com.demo.bookapp.representationalmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.awt.print.Book;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Relation(itemRelation = "book", collectionRelation = "books")
public class BookModel extends RepresentationModel<BookModel>{
    private int id;
    private String isbn;
    private String title;
    private String author;
    private BigDecimal price;
}
