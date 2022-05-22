package com.springland365.jpafundamental.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name="tbl_state" , schema="onetomany")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;


    @ManyToOne
    @JoinColumn(name="country_id")
    Country  country ;
}
