package com.springland365.jpafundamental.elementcollection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Embeddable
public class PhoneNumber {

    @Enumerated(EnumType.STRING)
    Type type ;

    String number ;

}
