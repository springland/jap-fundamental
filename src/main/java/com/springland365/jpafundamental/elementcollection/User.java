package com.springland365.jpafundamental.elementcollection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name="tbl_user" , schema="elementcollection")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id  ;

    String name  ;

    @ElementCollection
    @CollectionTable(name="tbl_phone" , schema = "elementcollection" , joinColumns =  {
            @JoinColumn(name="user_id")
    })

    @MapKeyColumn( name="number")
    @Column(name="type")
    Map<String , String>  phoneNumberMap ;


    @ElementCollection
    @CollectionTable(name = "tbl_address" , schema ="elementcollection"  , joinColumns = {
            @JoinColumn(name = "user_id")
    })
    List<Address> addresses ;


}
