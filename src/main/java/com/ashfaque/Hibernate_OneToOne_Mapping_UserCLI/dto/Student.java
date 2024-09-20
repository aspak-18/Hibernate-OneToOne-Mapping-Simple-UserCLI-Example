package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    @OneToOne
    @JoinColumn(name = "aadhar_no")
    private Aadhar aadhar;

    @Override
    public String toString() {
        return "Student ==> [" +
                "  Id=" + id +
                ", Name=" + name +
                ", Email=" + email +
                "]";
    }
}
