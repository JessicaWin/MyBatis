package com.jessica.dao;

import com.jessica.entity.Employee;

import java.io.IOException;
import java.util.List;

public interface IEmployeeDao {
    Employee findByEmpNo(int empNo) throws IOException;
}
