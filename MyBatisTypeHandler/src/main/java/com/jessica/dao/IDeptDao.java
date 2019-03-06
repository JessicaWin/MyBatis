package com.jessica.dao;

import com.jessica.entity.Dept;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;

public interface IDeptDao {
    void insertDept(Dept dept) throws IOException;
    Dept findByDeptNo(int depNo) throws IOException;
    List<Dept> findAll() throws IOException;
}
