package com.springland365.jpafundamental.inheritance.singletable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SingleTableTest {
    @Autowired
    EntityManager entityManager ;


    @Test
    public void test()
    {
        CircleSingleTable  circleSingleTable = new CircleSingleTable();
        circleSingleTable.setRadius(10);
        circleSingleTable.setColor("Red");

        entityManager.persist(circleSingleTable);

        circleSingleTable = new CircleSingleTable();

        circleSingleTable.setRadius(20);
        circleSingleTable.setColor("Black");

        entityManager.persist(circleSingleTable);

        RectangleSingleTable  rect = new RectangleSingleTable();
        rect.setColor("Blue");

        entityManager.persist(rect);

        Query query = entityManager.createQuery("select s  from ShapeSingleTable s");

        List<ShapeSingleTable> results = query.getResultList();
        assertEquals(results.size() , 3);

        query = entityManager.createQuery("select c  from CircleSingleTable c");
        List<CircleSingleTable> circles = query.getResultList();
        assertEquals(circles.size() , 2);

        query = entityManager.createQuery("select r  from RectangleSingleTable r");
        List<RectangleSingleTable> rects = query.getResultList();
        assertEquals(rects.size() , 1);




    }
}
