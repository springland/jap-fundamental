package com.springland365.jpafundamental.onetoone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional
public class OneToOneTest {

    @Autowired
    EntityManager em ;

    @Test
    @Transactional
    public void testUnidirection()
    {

        Country usa = new Country();
        usa.setName("USA");

        Capital dc = new Capital();
        dc.setName("Washington DC");

        usa.setCapital(dc);

        em.persist(usa);

        em.flush();

        Long countryId = usa.getId();

        Country queried = em.find(Country.class , countryId);
        assertEquals(queried.getName() , "USA");

        assertNotNull(queried.getCapital());

        assertEquals(queried.getCapital().getName() , "Washington DC");

    }

    @Test
    @Transactional
    public void testBidirection()
    {
        Person peter = new Person();
        peter.setName("Peter");

        FingerPrint peterFingerPrint = new FingerPrint();
        peterFingerPrint.setData("Peter FINGER PRINT DATA");

        peter.setFingerPrint(peterFingerPrint);
        peterFingerPrint.setPerson(peter);

        em.persist(peter);
        Long peterPersonId = peter.getId();

        FingerPrint tomFingerPrint = new FingerPrint();
        tomFingerPrint.setData("Tom Finger Print");

        Person tom = new Person();
        tom.setName("Tom");
        tom.setFingerPrint(tomFingerPrint);
        tomFingerPrint.setPerson(tom);

        em.persist(tomFingerPrint);
        Long tomFingerPrintId = tomFingerPrint.getId();

        Person queriedPerson = em.find(Person.class , peterPersonId);
        assertEquals(queriedPerson.name , "Peter");

        assertEquals(queriedPerson.getFingerPrint().getData() , "Peter FINGER PRINT DATA");


        FingerPrint fingerPrint = em.find(FingerPrint.class , tomFingerPrintId);
        assertEquals(fingerPrint.id , tomFingerPrint.id);
        assertEquals(fingerPrint.data , tomFingerPrint.data);

        assertEquals(fingerPrint.getPerson().getId() , tom.getId());

    }
}
