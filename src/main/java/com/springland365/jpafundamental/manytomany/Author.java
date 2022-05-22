package com.springland365.jpafundamental.manytomany;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tbl_author" , schema="manytomany")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable( name="tbl_author_book"  , schema="manytomany" , joinColumns = {@JoinColumn(name="author_id")} , inverseJoinColumns ={@JoinColumn(name="book_id")} )
    List<Book> books ;



}
