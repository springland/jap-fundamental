package com.springland365.jpafundamental.onetomany;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Slf4j
@Transactional
public class OneToManyTest {

    @Autowired
    EntityManager em ;

    @Test
    @Transactional
    public void unidirection()
    {

            Person peter = new Person();
            peter.setName("Peter");

            Phone mobile = new Phone();
            mobile.setType(PhoneType.MOBILE);
            mobile.setPhoneNumber("2015505682");

            Phone homePhone = new Phone();
            homePhone.setType(PhoneType.HOME);
            homePhone.setPhoneNumber("2017786236");

            peter.setPhones(Stream.of(mobile , homePhone).collect(Collectors.toList()));

            em.persist(peter);


            em.flush();

            em.detach(peter);

            Person person = em.find(Person.class , peter.id);
            assertEquals(person.getName() , "Peter");

            assertEquals(person.getPhones().size() , 2);

            peter.phones.stream().forEach(
                    phone -> log.info(phone.toString())
            );

    }

    @Test
    @Transactional
    public void testBiDirection()
    {
        Country usa = new Country();
        usa.setName("USA");

        State ct = new State();
        ct.setName("CT");
        ct.setCountry(usa);

        State ma = new State();
        ma.setName("MA");
        ma.setCountry(usa);

        State ny = new State();
        ny.setName("NY");
        ny.setCountry(usa);

        usa.setStates(Stream.of(ct , ma , ny).collect(Collectors.toList()));

        em.persist(usa);

        em.detach(usa);

        Country country = em.find(Country.class , usa.getId());
        assertEquals(country.getStates().size() , 3);


        State state = em.find(State.class , ma.getId());
        assertEquals(state.getCountry().getId() , usa.getId());
        assertEquals(state.getCountry().getName() , "USA");


    }
}
