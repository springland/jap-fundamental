package com.springland365.jpafundamental.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="tbl_person" , schema = "dto")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String firstName ;
    String lastName ;


    public PersonDTO toDTO()
    {
        PersonDTO dto  = PersonDTO.builder()
                .id(this.id).firstName(this.firstName).lastName(this.lastName).build();

        return dto ;
    }
}
