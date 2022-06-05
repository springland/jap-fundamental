package com.springland365.jpafundamental.simple;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name="tbl_person_sequence_id" , schema = "simple")
public class PersonSequenceId {

    @Id
    // use default hiberate_sequence
    @GeneratedValue(strategy = GenerationType.SEQUENCE  ,generator = "person_sequence")
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 100)
    Long id ;

    String name ;
}
