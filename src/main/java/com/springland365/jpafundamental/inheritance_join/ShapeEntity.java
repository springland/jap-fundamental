package com.springland365.jpafundamental.inheritance_join;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="tbl_shape" , schema = "inheritance_join")
public abstract class ShapeEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id ;

    String color ;


}
