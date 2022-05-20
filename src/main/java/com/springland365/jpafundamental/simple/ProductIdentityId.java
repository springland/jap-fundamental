package com.springland365.jpafundamental.simple;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name="tbl_product_identity_id" , schema="simple")
public class ProductIdentityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;

}
