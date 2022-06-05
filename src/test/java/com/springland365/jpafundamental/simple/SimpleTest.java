package com.springland365.jpafundamental.simple;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

@Slf4j
@Transactional
public class SimpleTest {

    @Autowired
    ProductIdentityIdRepo productIdentityIdrepo;

    @Autowired
    PersonSequenceIdRepo personSequenceIdRepo;

    @Autowired
    ProductSequenceIdRepo productSequenceIdRepo ;

    @Test
    @Order(1)
    public void testSequenceId()
    {
        ProductSequenceId  product = new ProductSequenceId();
        product.setName("P1");

        PersonSequenceId  person = new PersonSequenceId();
        person.setName("James");

        productSequenceIdRepo.save(product);
        personSequenceIdRepo.save(person);

        // person and product are backed by different sequence
        // then the id can be same without conflict

        log.info("Product id " + product.id);
        log.info("Person id " + person.id);
        assertEquals(product.id , person.id);
    }



    @Test
    @Order(2)
    public void testProductIdentityIdCRUD()
    {
        ProductIdentityId product = new ProductIdentityId() ;
        product.setName("P1");

        assertNull(product.id);
        productIdentityIdrepo.save(product);

        assertNotNull(product.id);

        Long id = product.getId();

        Optional<ProductIdentityId> result = productIdentityIdrepo.findById(id);

        assertEquals(result.get().getName() , "P1");


        product.setName("P2");
        productIdentityIdrepo.save(product);
        //repo.flush();


        result = productIdentityIdrepo.findById(id);
        assertEquals(result.get().getName() , "P2");


        productIdentityIdrepo.delete(product);
        result = productIdentityIdrepo.findById(id);
        assertTrue(result.isEmpty());


    }


}
