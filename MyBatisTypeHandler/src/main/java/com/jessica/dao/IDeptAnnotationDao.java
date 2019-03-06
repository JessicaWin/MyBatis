package com.jessica.dao;

import com.jessica.entity.Dept;
import com.jessica.handler.BooleanTypeHandler;
import jdk.internal.instrumentation.TypeMapping;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.TypeDiscriminator;

import java.io.IOException;
import java.util.List;

public interface IDeptAnnotationDao {
    @Insert("insert into dept2 (depNo, depName, loc, flag) values(#{depNo}, #{depName}, #{loc}, #{flag})")
    @SelectKey(statement="select max(depNo)+1 from dept2", keyProperty="depNo", before=true, resultType=int.class)
    void insertDept(Dept dept) throws IOException;
    @Select("select * from dept2 where depNo = #{depNo}")
    Dept findByDeptNo(int depNo) throws IOException;
    @Select("select * from dept2")
    List<Dept> findAll() throws IOException;
}
