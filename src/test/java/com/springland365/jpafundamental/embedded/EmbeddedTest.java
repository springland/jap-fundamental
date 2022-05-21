package com.springland365.jpafundamental.embedded;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class EmbeddedTest {

    @Autowired
    EntityManager em ;

    @Test
    @Transactional
    public void test()
    {

        Customer customer = new Customer() ;
        customer.setName("C1");
        Address addr = new Address();
        addr.setCity("Stamford");
        addr.setState("CT");
        addr.setStreet("10 First Street");
        addr.setZipCode("06905");
        customer.setAddress(addr);

        em.persist(customer);
        em.flush();
        assertNotNull(customer.getId());
        Long customerId = customer.id;

        Customer  queriedCustomer = em.find(Customer.class , customerId);
        assertEquals(queriedCustomer.getAddress().getStreet() , "10 First Street");
        assertEquals(queriedCustomer.getAddress().getState() , "CT");


        Company company = new Company();
        company.setName("Company A");
        addr = new Address();
        addr.setZipCode("77017");
        addr.setState("TX");
        addr.setStreet("9038 Cherry Ave");
        addr.setCity("Houston");
        company.setAddress(addr);

        em.persist(company);
        assertNotNull(company.getId());

        Long companyId = company.getId();

        Company queriedCompany = em.find(Company.class , companyId);
        assertEquals(queriedCompany.getAddress().getStreet() , "9038 Cherry Ave");
        assertEquals(queriedCompany.getAddress().getState() , "TX");





    }
}
