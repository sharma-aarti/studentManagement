package com.studentManagement.repository;

import com.studentManagement.Entity.Course;
import com.studentManagement.Entity.CourseMaterial;
import com.studentManagement.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        List<Course> list = List.of(Course
                        .builder()
                        .title("science").credit(10)
                        .build(),
                Course
                        .builder()
                        .title("history")
                        .credit(10)
                        .build()
                );
        Teacher teacher = Teacher.builder()
                .firstName("francis")
                .lastName("mary")
                //.courses(list)
                .build();
teacherRepository.save(teacher);
    }

}