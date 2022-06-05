package com.springland365.jpafundamental.inheritance.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name="tbl_shape" , schema = "inheritance_singletable")
public abstract class ShapeSingleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String color ;
}
