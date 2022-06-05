package com.springland365.jpafundamental.inheritance.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="CircleSingleTable")
@Getter
@Setter
@DiscriminatorValue("Circle")
public class Circle extends Shape {

    int radius ;

}
