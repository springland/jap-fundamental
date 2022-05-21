package com.springland365.jpafundamental.onetoone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name = "tbl_capital" , schema="onetoone")
@NoArgsConstructor
@AllArgsConstructor

public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;



}
