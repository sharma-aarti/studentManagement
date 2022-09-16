package com.studentManagement.repository;

import com.studentManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student> findByFirstName(String firstName);
     List<Student> findByGuardianName(String name);

//JPQL
     @Query("select s from Student s where s.email = ?1")
     Student getStudentByEmail(String email);

//JPQL
     @Query("select s.firstName from Student s where s.email = ?1")
     String getStudentFirstNameByEmail(String email);

//native query
     @Query(value = "select * from student_chart s where s.email_address = ?1", nativeQuery = true)
     Student getStudentByEmailByNativeQuery(String email);

// native named param
     @Query(value = "select * from student_chart s where s.email_address = :email", nativeQuery = true)
     Student getStudentByEmailByNativeQueryNamedParam(@Param("email") String email);

     @Modifying
     @Transactional
     @Query(value = "update student_chart set first_name =?1 where email_address =?2 ", nativeQuery = true)
    int updateFirstNameByEmail(String firstName, String email);



}
