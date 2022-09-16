package com.studentManagement.repository;

import com.studentManagement.Entity.Address;
import com.studentManagement.Entity.Course;
import com.studentManagement.Entity.Student;
import com.studentManagement.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> list = courseRepository.findAll();
        System.out.println(list);
    }

    @Test
    public void saveCourse(){
        Course course = Course.builder().
                          title("DBA")
                .credit(23)
                .teacher(Teacher.builder().firstName("aarti").lastName("sharma").build()).build();
        courseRepository.save(course);
    }

@Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable SecondPageWithThreeRecords= PageRequest.of(1,3);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        // total elements in the course table in the database
        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
    System.out.println("totalElements = "+ totalElements );
    System.out.println("totalPages = "+ totalPages );
        System.out.println("courses = "+ courses );

}
@Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,3, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,3,Sort.by("credit").descending());
        Pageable sortByTitleAndCredit = PageRequest.of(0,3,Sort.by("title")
                                                       .descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortByTitleAndCredit).getContent();
        System.out.println(courses);

}
@Test
    public void findAllByTitleContainingTest(){
        Pageable firstPageWithFourElements = PageRequest.of(0,4);
        List<Course> list = courseRepository.findByTitleContaining("d",firstPageWithFourElements).getContent();
        System.out.println(list);
}

@Test
    public void saveCourseWithTeacherAndStudent(){
        Teacher teacher = Teacher.builder()
                .firstName("lizzee")
                .lastName("morgan")
                .build();
        Course course = Course.builder().title("geography")
                .credit(12)
                .teacher(teacher).build();

        course.addStudent(Student.builder()
                .firstName("roshan")
                .lastName("singh")
                .email("singh@gmail.com")
                .address(new Address("Iowa","nyc")).build());

    course.addStudent(Student.builder()
            .firstName("raunak")
            .lastName("singh")
            .email("raunak@gmail.com")
            .address(new Address("bihar","patna")).build());

        courseRepository.save(course);
}
}