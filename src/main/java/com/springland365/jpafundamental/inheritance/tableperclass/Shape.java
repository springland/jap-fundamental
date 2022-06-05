package com.springland365.jpafundamental.inheritance.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="ShapeTablePerClass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Shape {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  // causing trouble

    @GeneratedValue
    Long id ;

    String color ;

}
