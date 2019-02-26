package com.jessica.dao;

import com.jessica.entity.Dept;

import java.io.IOException;
import java.util.List;

public interface IDeptDao {
    void insertDept2(Dept dept) throws IOException;
    List<Dept> selectDept2(Dept dept) throws IOException;
    List<Dept> selectAll(String tableName) throws IOException;
}
