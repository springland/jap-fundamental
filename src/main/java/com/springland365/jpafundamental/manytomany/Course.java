package com.springland365.jpafundamental.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tbl_course" , schema="manytomany")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    String name ;

    @OneToMany(mappedBy = "course" , cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    List<CourseRegistration>  registrations ;

    @Column(name="deadline")
    LocalDate registrationDeadLine ;
}
