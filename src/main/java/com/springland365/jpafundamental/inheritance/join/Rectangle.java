package com.springland365.jpafundamental.inheritance.join;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="tbl_rectangle" , schema = "inheritance_join")
@PrimaryKeyJoinColumn(name = "shapeId")
public class Rectangle extends Shape {


    protected  int width ;

    @Override
    public String toString() {
        return "RectangleEntity{" +
                "width=" + width +
                ", height=" + height +
                ", id=" + id +
                ", color='" + color + '\'' +
                '}';
    }

    protected int  height ;


}
