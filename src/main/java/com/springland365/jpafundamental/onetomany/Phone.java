package com.springland365.jpafundamental.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="tbl_phone" , schema="onetomany")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @Column(name="number")
    String phoneNumber ;

    @Enumerated(EnumType.STRING)
    PhoneType type ;


    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
