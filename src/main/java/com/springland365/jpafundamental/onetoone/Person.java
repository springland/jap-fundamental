package com.springland365.jpafundamental.onetoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="tbl_person" , schema="onetoone")
public class Person {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id ;

    String name ;

    @OneToOne(mappedBy = "person" , fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    FingerPrint  fingerPrint ;

}
