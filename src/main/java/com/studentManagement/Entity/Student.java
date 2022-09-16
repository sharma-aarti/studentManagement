package com.studentManagement.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "guardian")
@Builder //to add the builder pattern to my entity
@Table(name="student_chart",
       uniqueConstraints = @UniqueConstraint(
               name = "unique_emailId",
               columnNames = {"email_address",
                            "first_name"}
       ))
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "stdnt_sequence",
            allocationSize = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long studentId;
    @Column(name="first_name",
            nullable = false)
    private String firstName;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private String lastName;
    @Column(name="email_address", nullable = false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "guardian_id",referencedColumnName = "guardianId")
    private Guardian guardian;

    @Embedded
    private Address address;




}
