package com.springland365.jpafundamental.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tbl_book" , schema="manytomany")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String title ;

    String isbn ;

    LocalDate publishDate ;

    @ManyToMany(mappedBy = "books" ,cascade = CascadeType.PERSIST)

    List<Author>  authors ;



}
