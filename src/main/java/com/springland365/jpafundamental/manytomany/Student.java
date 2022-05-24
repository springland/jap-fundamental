package com.springland365.jpafundamental.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbl_student" , schema = "manytomany")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;

    @OneToMany(mappedBy = "student" , cascade = CascadeType.PERSIST)
    List<CourseRegistration>  courseRegistrations  ;
}
