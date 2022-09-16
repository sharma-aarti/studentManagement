package com.studentManagement.repository;

import com.studentManagement.Entity.Course;
import com.studentManagement.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder().
                title("maths").credit(2).build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                        .url("www.wikipedia.math.com")
                                .course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        System.out.println(list);
    }

}