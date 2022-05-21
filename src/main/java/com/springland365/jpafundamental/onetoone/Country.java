package com.springland365.jpafundamental.onetoone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name = "tbl_country" , schema="onetoone")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id ;

    String name ;


    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinColumn(name="capital_id"  , referencedColumnName = "id")
    Capital  capital ;


}
