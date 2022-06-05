package com.springland365.jpafundamental.inheritance.join;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@Slf4j
public class JoinTest {

    @Autowired
    EntityManager  entityManager ;

    @Test
    public void test()
    {

        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setColor("Red");


        entityManager.persist(circle);

        circle = new Circle();
        circle.setRadius(10);
        circle.setColor("Black");

        entityManager.persist(circle);


        Rectangle rectangleEntity = new Rectangle();

        rectangleEntity.setColor("Blue") ;

        entityManager.persist(rectangleEntity);


        Query query = entityManager.createQuery(" select s from ShapeEntity s");
        List<Shape> shapes = query.getResultList();
        assertEquals(shapes.size() , 3);

        shapes.stream().forEach( s -> log.info(s.toString()));


        query = entityManager.createQuery(" select r from RectangleEntity r");

        List<Rectangle> rectangleEntities = query.getResultList();
        assertEquals(rectangleEntities.size() , 1);
        Rectangle rect = rectangleEntities.get(0);
        assertEquals(rect.getColor() , "Blue");


        query = entityManager.createQuery(" select c from CircleEntity c");
        List<Circle> circleEntities = query.getResultList();
        assertEquals(circleEntities.size() , 2);

    }
}
