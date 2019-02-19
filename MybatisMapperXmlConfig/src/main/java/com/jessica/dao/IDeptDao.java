package com.kaikeba.dao;

import com.kaikeba.entity.Dept;

import java.io.IOException;
import java.util.List;

public interface IDeptDao {
    void insert(Dept dept) throws IOException;
    Dept findByNameAndLoc(String depName, String loc);
    Dept findById(int depName);
    List<Dept> findAll();
}
