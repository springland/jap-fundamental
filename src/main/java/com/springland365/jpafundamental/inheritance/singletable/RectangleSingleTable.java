package com.springland365.jpafundamental.inheritance.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("Rectangle")
public class RectangleSingleTable extends ShapeSingleTable {

    int width ;

    int height ;

}
