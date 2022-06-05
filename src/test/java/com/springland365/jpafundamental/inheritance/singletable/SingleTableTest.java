package com.springland365.jpafundamental.inheritance.singletable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("default")
@Transactional
public class SingleTableTest {
    @Autowired
    EntityManager entityManager ;


    @Test
    public void test()
    {
        Circle circleSingleTable = new Circle();
        circleSingleTable.setRadius(10);
        circleSingleTable.setColor("Red");

        entityManager.persist(circleSingleTable);

        circleSingleTable = new Circle();

        circleSingleTable.setRadius(20);
        circleSingleTable.setColor("Black");

        entityManager.persist(circleSingleTable);

        Rectangle rect = new Rectangle();
        rect.setColor("Blue");

        entityManager.persist(rect);

        Query query = entityManager.createQuery("select s  from ShapeSingleTable s");

        List<Shape> results = query.getResultList();
        assertEquals(results.size() , 3);

        query = entityManager.createQuery("select c  from CircleSingleTable c");
        List<Circle> circles = query.getResultList();
        assertEquals(circles.size() , 2);

        query = entityManager.createQuery("select r  from RectangleSingleTable r");
        List<Rectangle> rects = query.getResultList();
        assertEquals(rects.size() , 1);




    }
}
