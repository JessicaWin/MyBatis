package com.jessica.dao;

import com.jessica.OneToManyProvider;
import com.jessica.entity.Dept;
import com.jessica.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Mapper
public interface IDeptAnnotationDao {
    @Select("select * from employee2 where depNo = #{depNo}")
    @ConstructorArgs({
            @Arg( column = "hireDate", javaType = Date.class)
    })
    @Results(id="resultMap", value={
            @Result(id = true, column = "empNo", property = "empNo"),
            @Result(column = "eName", property = "eName"),
            @Result(column = "job", property = "job"),
            @Result(column = "dal", property = "dal"),
            @Result(column = "hireDate", property = "hireDate"),
            @Result(column = "depNo", property = "depNo")
    })
    List<Employee> selectEmployeeByDepNo(int depNo);

    @Select("select * from dept where depNo = #{depNo}")
    @Results(id="resultMapAnnotation", value={
          @Result(id = true, column = "depNo", property = "depNo", one = @One),
          @Result(column = "depName", property = "depName"),
          @Result(column = "col", property = "col"),
          @Result(column = "depNo", property = "employeeList",
                  many = @Many(select = "com.jessica.dao.IDeptAnnotationDao.selectEmployeeByDepNo",
                          fetchType= FetchType.LAZY))
    })
    Dept selectDept(int number) throws IOException;

    @SelectProvider(type = OneToManyProvider.class, method = "generateSql")
    @Results(value={
            @Result(id = true, column = "depNo", property = "depNo", one = @One),
            @Result(column = "depName", property = "depName"),
            @Result(column = "col", property = "col"),
            @Result(column = "depNo", property = "employeeList", javaType=List.class,
                    many=@Many(select="com.jessica.dao.IDeptAnnotationDao.selectEmployeeByDepNo"))
    })
    Dept selectField(Dept dept) throws IOException;
}
