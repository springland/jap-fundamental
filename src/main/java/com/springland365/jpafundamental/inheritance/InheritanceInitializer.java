package com.springland365.jpafundamental.inheritance;

import com.springland365.jpafundamental.inheritance.singletable.Circle;
import com.springland365.jpafundamental.inheritance.singletable.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@Transactional
@Profile("local")
public class InheritanceInitializer implements ApplicationRunner {

    @Autowired
    EntityManager  entityManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        createSingleTableEntities();
        createJoinTableEntities();
        createTablePerClassEntities();
    }

    protected void createTablePerClassEntities()
    {
        com.springland365.jpafundamental.inheritance.tableperclass.Circle circle = new com.springland365.jpafundamental.inheritance.tableperclass.Circle();
        circle.setColor("Red");
        circle.setRadius(10);
        entityManager.persist(circle);

        circle = new com.springland365.jpafundamental.inheritance.tableperclass.Circle() ;
        circle.setColor("Black");
        circle.setRadius(20);

        entityManager.persist(circle);


        com.springland365.jpafundamental.inheritance.tableperclass.Rectangle rect = new com.springland365.jpafundamental.inheritance.tableperclass.Rectangle();
        rect.setColor("Blue");
        rect.setHeight(10);
        rect.setWidth(20);

        entityManager.persist(rect);

    }
    protected void createSingleTableEntities()
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

    }

    protected void createJoinTableEntities()
    {
        com.springland365.jpafundamental.inheritance.join.Circle circle = new com.springland365.jpafundamental.inheritance.join.Circle();
        circle.setRadius(20);
        circle.setColor("Red");


        entityManager.persist(circle);

        circle = new com.springland365.jpafundamental.inheritance.join.Circle();
        circle.setRadius(10);
        circle.setColor("Black");

        entityManager.persist(circle);


        com.springland365.jpafundamental.inheritance.join.Rectangle rectangleEntity = new com.springland365.jpafundamental.inheritance.join.Rectangle();

        rectangleEntity.setColor("Blue") ;

        entityManager.persist(rectangleEntity);

    }
}
