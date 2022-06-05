package com.springland365.jpafundamental.inheritance.tableperclass;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="RectangleTablePerClass")
@Getter
@Setter
@Table(name="tbl_rectangle" , schema = "inheritance_tableperclass")
public class Rectangle extends Shape{

    int width ;

    int height ;
}
