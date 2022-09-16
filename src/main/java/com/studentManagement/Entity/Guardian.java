package com.studentManagement.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guardianId;
    private String name;
    private String email;
    private String mobileNo;

    public Guardian(String name, String email, String mobileNo) {
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    @OneToOne(mappedBy = "guardian")
    private Student student;


}
