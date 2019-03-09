package com.jessica.dao;

import com.jessica.ManyToOneProvider;
import com.jessica.entity.Dept;
import com.jessica.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.io.IOException;
import java.sql.Date;

public interface IEmployeeAnnotationDao {

    @Select("select * from dept where depNo = #{depNo}")
    @Results(id="resultMapAnnotation", value={
            @Result(id = true, column = "depNo", property = "depNo", one = @One),
            @Result(column = "depName", property = "depName"),
            @Result(column = "col", property = "col")
    })
    Dept selectDept(int number) throws IOException;

    @SelectProvider(type = ManyToOneProvider.class, method = "generateSql")
    @ConstructorArgs({
            @Arg(column = "hireDate", javaType = Date.class)
    })
    @Results({
            @Result(id = true, column = "empNo", property = "empNo"),
            @Result(column = "eName", property = "eName"),
            @Result(column = "job", property = "job"),
            @Result(column = "dal", property = "dal"),
            @Result(column = "hireDate", property = "hireDate"),
            @Result(column = "depNo", property = "depNo"),
            @Result(column = "depNo", javaType = Dept.class,
                    one=@One(select="com.jessica.dao.IEmployeeAnnotationDao.selectDept"))
    })
    Employee findByEmpNo(Employee empNo) throws IOException;
}
