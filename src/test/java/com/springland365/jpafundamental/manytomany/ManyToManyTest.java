package com.springland365.jpafundamental.manytomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional
public class ManyToManyTest {

    @Autowired
    EntityManager em ;


    @Test
    public void testAuthorBook()
    {
        Author timMcNamar = new Author() ;
        timMcNamar.setName("Tim McNamara");

        Book rustInAction = new Book();
        rustInAction.setTitle("Rust In Action");
        rustInAction.setIsbn("1617294551");
        rustInAction.setPublishDate(LocalDate.of(2021, 8 , 10));

        rustInAction.setAuthors(Stream.of(timMcNamar).collect(Collectors.toList()));
        timMcNamar.setBooks(Stream.of(rustInAction).collect(Collectors.toList()));

        Author johnCarnell = new Author();
        johnCarnell.setName("John Carnell");

        Author kalpitPatel = new Author();
        kalpitPatel.setName("Kalpit Patel");

        Book springMicroService = new Book();
        springMicroService.setTitle("Spring Microservices in Action");
        springMicroService.setIsbn("1617293989");
        springMicroService.setPublishDate(LocalDate.of(2017,06,11));

        springMicroService.setAuthors(Stream.of(johnCarnell).collect(Collectors.toList()));

        Book struts = new Book();
        struts.setTitle("Pro Jakarta Struts 2nd Edition");
        struts.setIsbn("159059228X");
        struts.setPublishDate(LocalDate.of(2004 , 2 , 26));
        struts.setAuthors(Stream.of(johnCarnell , kalpitPatel).collect(Collectors.toList()));

        kalpitPatel.setBooks(Stream.of(struts).collect(Collectors.toList()));


        Book j2eePattern = new Book();
        j2eePattern.setTitle("J2EE Design Patterns Applied");
        j2eePattern.setIsbn("1861005288");
        j2eePattern.setPublishDate(LocalDate.of(2002 , 06, 01));

        Author craigBerry = new Author() ;
        craigBerry.setName("Craig Berry");
        craigBerry.setBooks(Stream.of(j2eePattern).collect(Collectors.toList()));

        Author nadiaNashi = new Author();
        nadiaNashi.setName("Nadia Nashi");
        nadiaNashi.setBooks(Stream.of(j2eePattern).collect(Collectors.toList()));

        j2eePattern.setAuthors(Stream.of(craigBerry , nadiaNashi, johnCarnell).collect(Collectors.toList()));

        johnCarnell.setBooks(Stream.of(springMicroService , struts , j2eePattern).collect(Collectors.toList()));


        em.persist(timMcNamar);
        em.persist(johnCarnell);
        em.persist(kalpitPatel);
        em.persist(craigBerry) ;
        em.persist(nadiaNashi);


        Author author = em.find(Author.class ,johnCarnell.getId());
        assertEquals(author.getBooks().size() , 3);

        Book book = em.find(Book.class , j2eePattern.getId());
        assertEquals(book.getAuthors().size() , 3);

        book = em.find(Book.class , rustInAction.getId());
        assertEquals(book.getAuthors().get(0).getName() , timMcNamar.getName());


    }


    @Test
    @Transactional
    public void testCourseRegistration()
    {
        Student tom = new Student();
        tom.setName("tom");

        Student peter = new Student();
        peter.setName("peter");

        Student jay = new Student();
        jay.setName("jay");

        Course cpp = new Course();
        cpp.setName("c++");
        cpp.setRegistrationDeadLine(LocalDate.of(2022 , 06 ,30));

        Course java = new Course();
        java.setName("java");
        java.setRegistrationDeadLine(LocalDate.of(2022 , 07 ,31));

        Course python = new Course();
        python.setName("python");
        java.setRegistrationDeadLine(LocalDate.of(2022 , 8 ,31));


        CourseRegistration  reg1  = new CourseRegistration();
        reg1.setCourse(cpp);
        reg1.setStudent(tom);
        reg1.setRegistrationDate(LocalDate.of(2022 , 3 , 1));


        CourseRegistration reg2 = new CourseRegistration();
        reg2.setCourse(java);
        reg2.setStudent(tom);
        reg2.setRegistrationDate(LocalDate.of(2022 , 3 , 1));


        CourseRegistration reg3 = new CourseRegistration();
        reg3.setCourse(python);
        reg3.setStudent(tom);
        reg3.setRegistrationDate(LocalDate.of(2022 , 3 , 1));


        CourseRegistration reg4 = new CourseRegistration();
        reg4.setCourse(java);
        reg4.setStudent(peter);
        reg4.setRegistrationDate(LocalDate.of(2022 , 3 , 15));


        CourseRegistration reg5 = new CourseRegistration();
        reg5.setCourse(python);
        reg5.setStudent(peter);
        reg5.setRegistrationDate(LocalDate.of(2022 , 3 , 15));


        CourseRegistration reg6 = new CourseRegistration();
        reg6.setCourse(python);
        reg6.setStudent(jay);
        reg6.setRegistrationDate(LocalDate.of(2022 , 4 , 15));


        tom.setCourseRegistrations(Stream.of(reg1 , reg2 , reg3).collect(Collectors.toList()));

        peter.setCourseRegistrations(Stream.of(reg4 , reg5).collect(Collectors.toList()));

        jay.setCourseRegistrations(Stream.of(reg6).collect(Collectors.toList()));

        cpp.setRegistrations(Stream.of(reg1).collect(Collectors.toList()));

        java.setRegistrations(Stream.of(reg2 , reg4).collect(Collectors.toList()));

        python.setRegistrations(Stream.of(reg3 , reg5 , reg6).collect(Collectors.toList()));

        em.persist(reg1);
        em.persist(reg2);
        em.persist(reg3);
        em.persist(reg4);
        em.persist(reg5);
        em.persist(reg6);
        Course course = em.find(Course.class , python.getId());
        assertEquals(course.getRegistrations().size() , 3);
        List<String> studentNames = course.registrations.stream().map( r -> r.getStudent().getName()).collect(Collectors.toList());
        assertEquals(studentNames , Stream.of("tom" , "peter" , "jay").collect(Collectors.toList()));

        Student student =em.find(Student.class , peter.getId());
        List<String> courseNames = student.courseRegistrations.stream().map( c-> c.getCourse().getName()).collect(Collectors.toList());
        assertEquals(courseNames , Stream.of("java", "python").collect(Collectors.toList()));

        List<LocalDate> registionDates = peter.getCourseRegistrations().stream().map(r -> r.getRegistrationDate()).collect(Collectors.toList());
        assertEquals(registionDates , Stream.of(LocalDate.of(2022 , 3 , 15) , LocalDate.of(2022 , 3 , 15)).collect(Collectors.toList()));
    }
}
