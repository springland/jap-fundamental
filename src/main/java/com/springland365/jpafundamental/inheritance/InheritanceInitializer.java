package com.springland365.jpafundamental.inheritance;

import com.springland365.jpafundamental.inheritance.join.Circle;
import com.springland365.jpafundamental.inheritance.join.Rectangle;
import com.springland365.jpafundamental.inheritance.singletable.CircleSingleTable;
import com.springland365.jpafundamental.inheritance.singletable.RectangleSingleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@Transactional
public class InheritanceInitializer implements ApplicationRunner {

    @Autowired
    EntityManager  entityManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        createSingleTableEntities();
        createJoinTableEntities();
    }

    protected void createSingleTableEntities()
    {
        CircleSingleTable circleSingleTable = new CircleSingleTable();
        circleSingleTable.setRadius(10);
        circleSingleTable.setColor("Red");

        entityManager.persist(circleSingleTable);

        circleSingleTable = new CircleSingleTable();

        circleSingleTable.setRadius(20);
        circleSingleTable.setColor("Black");

        entityManager.persist(circleSingleTable);

        RectangleSingleTable rect = new RectangleSingleTable();
        rect.setColor("Blue");

        entityManager.persist(rect);

    }

    protected void createJoinTableEntities()
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

    }
}
