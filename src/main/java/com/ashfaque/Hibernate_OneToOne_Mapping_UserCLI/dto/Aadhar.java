package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Aadhar {
    @Id
    private long a_number;
    private LocalDate dob;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "Aadhar ==> [" +
                "Aadhar Number=" + a_number +
                ", Date of Birth=" + dob +
                ", Age=" + age +
                ", Gender=" + gender +
                "]";
    }
}
