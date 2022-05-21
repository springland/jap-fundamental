package com.springland365.jpafundamental.onetoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name="tbl_finger_print" , schema = "onetoone")
@Getter
@Setter
public class FingerPrint {

    @Id
    @GeneratedValue()
    Long id ;

    // Base64 encoded
    String data ;

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinColumn(name="person_id" , referencedColumnName="id")
    Person person ;


}
