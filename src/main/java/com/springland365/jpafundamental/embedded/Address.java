package com.springland365.jpafundamental.embedded;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {

    String street ;
    String city ;
    String state ;
    String zipCode ;

}
