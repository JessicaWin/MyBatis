package com.jessica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private  int empNo;
    private  String eName;
    private String job;
    private String dal;
    private Date hireDate;

    private int workAge;

    public  Employee(Date hireDate) {
        Date now = Date.valueOf("2019-02-26");
        this.hireDate = hireDate;
        this.workAge = now.getYear() - hireDate.getYear();
    }
}
