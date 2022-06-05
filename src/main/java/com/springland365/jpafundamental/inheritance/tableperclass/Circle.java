package com.springland365.jpafundamental.inheritance.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name="CircleTablePerClass")
@Table(name="tbl_circle" , schema="inheritance_tableperclass")
public class Circle extends Shape{

    protected int radius ;
}
