package com.studentManagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "State",
                column = @Column(name = "student_state")
        ),
        @AttributeOverride(
                name = "city",
                column = @Column(name = "student_city")
        )
}
)
public class Address {

    private String State;
    private String city;

}
