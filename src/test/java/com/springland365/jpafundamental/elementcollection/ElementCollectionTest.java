package com.springland365.jpafundamental.elementcollection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ElementCollectionTest {

    @Autowired
    EntityManager entityManager ;

    @Test
    public void test()
    {
        Query query = entityManager.createQuery("SELECT u from User u where name = :name" , User.class);
        query.setParameter("name" , "John");
        List<User> users = query.getResultList();

        User user = users.get(0);
        assertEquals(user.getName() , "John");
        assertEquals(user.getAddresses().size() , 1);

        assertEquals(user.getPhoneNumberMap().size() ,2);
        assertEquals(user.getPhoneNumberMap().get("201-132-7505") , Type.MOBILE.name());

        assertEquals(user.getPhoneNumberMap().get("201-323-1805") , Type.OFFICE.name());


    }
}
