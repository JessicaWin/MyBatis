package com.jessica.dao;

import com.jessica.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IDeptDao {
    Dept selectDept(int number) throws IOException;
    Dept selectField(int number) throws IOException;
    Dept selectField2(int number) throws IOException;
}
