package com.springland365.jpafundamental.onetomany;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="onetomany_person")
@Getter
@Setter
@Table(name="tbl_person" , schema="onetomany")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;

    @OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @JoinColumn(name="person_id" )
    List<Phone> phones  ;
}
