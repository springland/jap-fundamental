package com.springland365.jpafundamental.inheritance.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="RectangleSingleTable")
@Getter
@Setter
@DiscriminatorValue("Rectangle")
public class Rectangle extends Shape {

    int width ;

    int height ;

}
