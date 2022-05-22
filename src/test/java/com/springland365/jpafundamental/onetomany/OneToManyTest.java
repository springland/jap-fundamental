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
}
