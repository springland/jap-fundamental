package com.springland365.jpafundamental.elementcollection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {

    @Column(name = "house_number")
    String houseNumber ;


    String street ;
    String city ;
    String state ;
    @Column(name="zip_code")
    String zipCode ;
}
