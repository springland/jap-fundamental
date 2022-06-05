package com.springland365.jpafundamental.dto;



import javax.persistence.PersistenceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Transactional
public class PersonDTOTest {

    @Autowired
    EntityManager entityManager ;

    @Test
    @Transactional
    public void testDTO()
    {
        PersonDTO dto = PersonDTO.builder().firstName("Tom").lastName("Brady").build();

        PersonEntity entity = dto.toEntity();
        entityManager.persist(entity);

        Long id = entity.getId();

        entity = entityManager.find(PersonEntity.class , id);

        dto = entity.toDTO() ;

        assertEquals(dto.firstName , "Tom");
        assertEquals(dto.lastName  , "Brady");

    }

    @Test
    public void testDTOEntityDetached()
    {
        assertThrows(PersistenceException.class , () -> {
            PersonDTO dto = PersonDTO.builder().firstName("Patrick").lastName("Mahomes").build();

            PersonEntity entity = dto.toEntity();
            entityManager.persist(entity);

            Long id = entity.getId();

            entity = entityManager.find(PersonEntity.class , id);

            dto = entity.toDTO() ;

            assertEquals(dto.firstName , "Patrick");
            assertEquals(dto.lastName  , "Mahomes");



            entity = dto.toEntity();
            // this is an detached entity
            entityManager.persist(entity);



        });
    }

    @Test
    public void testDTOReAttachEntity()
    {
        PersonDTO dto = PersonDTO.builder().firstName("Patrick").lastName("Mahomes").build();

        PersonEntity entity = dto.toEntity();
        entityManager.persist(entity);

        Long id = entity.getId();

        entity = entityManager.find(PersonEntity.class , id);

        dto = entity.toDTO() ;

        assertEquals(dto.firstName , "Patrick");
        assertEquals(dto.lastName  , "Mahomes");



        entity = dto.toEntity();
        entity =entityManager.merge(entity);
        entityManager.persist(entity);

    }
}
