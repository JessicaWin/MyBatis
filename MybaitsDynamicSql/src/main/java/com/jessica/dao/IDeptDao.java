package com.jessica.dao;

import com.jessica.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IDeptDao {
    List<Dept> selectDept1(Dept dept) throws IOException;
    List<Dept> selectDept2(Dept dept) throws IOException;
    List<Dept> selectDept3(Dept dept) throws IOException;
    List<Dept> selectAll(String tableName) throws IOException;
    int updateDept(Dept dept) throws IOException;
    List<Dept> findTrim(Dept dept) throws IOException;

    int insertForEach(List<Dept> deptList) throws IOException;
    List<Dept> findByList(List<Integer> keyList) throws IOException;
    List<Dept> findByArray(Integer[] keyArray) throws IOException;
    List<Dept> findByMap(@Param(value = "keyMap")Map<String, Integer> keyMap) throws IOException;
}
