package com.studentManagement.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Course {


    @Id
    @SequenceGenerator(
            name ="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
        private Teacher teacher;

            @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(
                    name ="student_course_mapping",
                    joinColumns =  @JoinColumn(
                            name = "course_id",
                            referencedColumnName = "courseId"
                    ),
                    inverseJoinColumns = @JoinColumn(
                            name = "student_id",
                            referencedColumnName = "studentId"
                    )
            )

    List<Student> students;

            public void addStudent(Student student){
                if(students == null){
                    students = new ArrayList<>();
                }
                students.add(student);
            }
}
