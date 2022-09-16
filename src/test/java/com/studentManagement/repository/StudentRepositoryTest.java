package com.studentManagement.repository;

import com.studentManagement.Entity.Address;
import com.studentManagement.Entity.Guardian;
import com.studentManagement.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
@Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student s = Student.builder()
                .firstName("ish")
                .lastName("jadeja")
                .email("ish@gmail.com")
                .guardian(new Guardian("raj.k","raj.k@gmail.com","78980566")).build();

        studentRepository.save(s);
    }

@Test
public void saveStudentWithAddress(){
        Student student = Student.builder()
                .firstName("ram")
                .lastName("prakash")
                .email("prakash@gmail.com")
                .guardian(new Guardian("ravi","ravi@gmail.com","7895666897"))
               .address(new Address("uttar pradesh","meerut"))
                .build();

        studentRepository.save(student);
}
    @Test
    public void printAllStudent(){
       List studentList =  studentRepository.findAll();
       System.out.println(studentList
       );
    }

    @Test
    public void printStudentByFirstName(){
       List<Student> list =  studentRepository.findByFirstName("ram");
       System.out.println(list);

    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> list =  studentRepository.findByGuardianName("ravi");
        System.out.println(list);

    }
    @Test
    public void printStudentByEmail(){
       Student student = studentRepository.getStudentByEmail("ram@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmail(){
        String name = studentRepository.getStudentFirstNameByEmail("ram@gmail.com");
        System.out.println("firstName =" + name);
    }
    @Test
    public void printStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmailByNativeQuery("ram@gmail.com");
        System.out.println("Student =" + student);
    }

    @Test
    public void printStudentByEmailNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailByNativeQueryNamedParam("ram@gmail.com");
        System.out.println("Student =" + student);
    }

    @Test
    public void printUpdateFirstNameByEmail(){
        int update = studentRepository.updateFirstNameByEmail("shyam","ram@gmail.com");
        String firstName = "shyam";
        System.out.println("Student's first name updated to = " + firstName+" "+ update);
    }


}