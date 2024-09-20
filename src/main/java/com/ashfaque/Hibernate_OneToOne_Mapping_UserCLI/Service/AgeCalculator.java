package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.Service;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static int getAge(LocalDate dob){
        LocalDate currentDate=LocalDate.now();
        return Period.between(dob,currentDate).getYears();
    }
}
