package com.jessica.dao;

import com.jessica.entity.Employee;

import java.io.IOException;
import java.util.List;

public interface IEmployeeDao {
    int insertEmployee(Employee employee) throws IOException;
    List<Employee> findAllEmp() throws IOException;
    Employee findByEmpNo(int num) throws IOException;
}
