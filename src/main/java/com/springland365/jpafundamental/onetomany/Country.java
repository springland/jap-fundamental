package com.springland365.jpafundamental.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="onetomany_country")
@Getter
@Setter
@Table( name="tbl_country" , schema="onetomany")
public class Country {

    @Id
    @GeneratedValue
    Long id ;

    String name ;

    @OneToMany(mappedBy = "country" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    List<State> states ;
}
