package com.springland365.jpafundamental.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tbl_course_registration" , schema = "manytomany")
public class CourseRegistration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="student_id")
    Student student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="course_id")
    Course course ;


    LocalDate registrationDate ;
}
