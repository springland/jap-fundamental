package com.springland365.jpafundamental.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonDTO {
    Long id ;

    String firstName ;
    String lastName ;


    public PersonEntity toEntity()
    {
        PersonEntity  entity = new PersonEntity();
        entity.setId(this.id);
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        return entity ;
    }
}
