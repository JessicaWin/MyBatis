package com.jessica.entity;
import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private int depNo;
    private String depName;
    private String loc;

    private List<Employee> employeeList;
}
