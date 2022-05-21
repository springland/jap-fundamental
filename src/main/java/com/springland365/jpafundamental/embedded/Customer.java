package com.springland365.jpafundamental.embedded;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_customer" , schema = "embedded")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;

    @Embedded
    @AttributeOverride(column=@Column(name="zipcode") , name="zipCode")
    @AttributeOverride(column=@Column(name="state_name") , name="state")

    Address address ;


}
