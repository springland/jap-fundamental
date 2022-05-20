package com.springland365.jpafundamental.simple;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name="tbl_product_sequence_id" , schema="simple")

public class ProductSequenceId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 100)
    Long id ;

    String name ;

}
