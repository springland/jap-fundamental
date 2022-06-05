package com.springland365.jpafundamental.inheritance.tableperclass;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("default")
@Transactional

public class TablePerClassTest {

    @Autowired
    EntityManager entityManager ;

    @Test
    public void test()
    {

        Circle  circle = new Circle();
        circle.setColor("Red");
        circle.setRadius(10);
        entityManager.persist(circle);

        circle = new Circle() ;
        circle.setColor("Black");
        circle.setRadius(20);

        entityManager.persist(circle);


        Rectangle rect = new Rectangle();
        rect.setColor("Blue");
        rect.setHeight(10);
        rect.setWidth(20);

        entityManager.persist(rect);


        Query query =  entityManager.createQuery(" SELECT s from ShapeTablePerClass s ");
        List<Shape>  shapes = query.getResultList();
        assertEquals(shapes.size() , 3);

        query = entityManager.createQuery(" SELECT c from CircleTablePerClass c");
        List<Circle> circles = query.getResultList();
        assertEquals(circles.size() , 2);

        query = entityManager.createQuery((" SELECT  r from RectangleTablePerClass r"));
        List<Rectangle> rectangles = query.getResultList();
        assertEquals(rectangles.size() , 1);

    }
}
