package com.jessica.dao;

import com.jessica.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.IOException;
import java.util.List;

@Mapper
public interface IDeptAnnotationDao {
    @Insert("insert into dept (depName, loc) values(#{depName}, #{loc})")
    int insert(Dept dept) throws IOException;

    @Select("select * from dept where depName= #{depName}  and loc = #{loc}")
    List<Dept>  findByNameAndLoc(@Param(value = "depName") String depName, @Param(value = "loc") String loc);

    @Select("select * from dept where depNo = #{depNo}")
    Dept findById(int depNo);

    @Select("select * from dept")
    List<Dept> findAll();
}
