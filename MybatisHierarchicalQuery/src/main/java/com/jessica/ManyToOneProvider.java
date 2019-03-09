package com.jessica;

import com.jessica.entity.Employee;
import org.apache.ibatis.jdbc.SQL;

public class ManyToOneProvider {
    private String employeeTableName = "employee2";
    public String generateSql(Employee emp) {
        SQL sql = new SQL().SELECT("*").FROM(employeeTableName).WHERE("empNo=#{empNo}");
        return  sql.toString();
    }
}
