package com.jessica.dao;

import com.jessica.entity.Dept;
import com.jessica.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TestDept {
    private Properties properties;
    private SqlSession session;
    private Logger logger = Logger.getLogger(TestDept.class);
    private IDeptDao iDeptDao;
    private IEmployeeDao iEmployeeDao;
    @Before
    public void init() throws IOException {
        this.properties = new Properties();
        this.properties.load(Resources.getResourceAsStream("config.properties"));
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(is, "development", properties);
        this.session = factory.openSession();
        this.iDeptDao = this.session.getMapper(IDeptDao.class);
        this.iEmployeeDao = this.session.getMapper(IEmployeeDao.class);
    }

    @Test
    public void testSelect() throws IOException {
        Dept dept = this.iDeptDao.selectDept(27);
        logger.debug(dept);
    }

    @Test
    public void testSelectField() throws IOException {
        Dept dept = this.iDeptDao.selectField(27);
        logger.debug(dept);
    }

    @Test
    public void testSelectField2() throws IOException {
        Dept dept = this.iDeptDao.selectField2(27);
        logger.debug(dept);
    }

    @Test
    public void testFindEmployee() throws IOException {
        Employee employee = this.iEmployeeDao.findByEmpNo(5);
        logger.debug(employee);
    }

    @After
    public void clear() {
        session.close();
    }
}
