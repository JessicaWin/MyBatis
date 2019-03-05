package com.jessica.dao;

import com.jessica.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Mapper
public interface IEmployeeAnnotationDao {
    @Insert("insert into employee (eName, job, dal, hireDate) values(#{eName}, #{job}, #{dal}, #{hireDate})")
    void insertEmployee(Employee employee) throws IOException;

    @Select("select * from employee")
    @ConstructorArgs({
            @Arg( column = "hireDate", javaType = Date.class)
    })
    List<Employee> findAllEmp() throws IOException;

    @Select("select * from employee where empNo = #{empNo}")
    Employee findByEmpNo(int num) throws IOException;
}
