package com.jessica.dao;

import com.jessica.entity.Dept;

import java.io.IOException;

public interface IDeptDao {
    Dept findByDeptNo(int depNo) throws IOException;
}
