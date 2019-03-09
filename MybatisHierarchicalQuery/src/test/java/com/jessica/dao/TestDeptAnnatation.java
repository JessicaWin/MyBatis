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
import java.util.Properties;

public class TestDeptAnnatation {
    private Properties properties;
    private SqlSession session;
    private Logger logger = Logger.getLogger(TestDeptAnnatation.class);
    private IDeptAnnotationDao iDeptDao;
    private IEmployeeAnnotationDao iEmployeeDao;
    @Before
    public void init() throws IOException {
        this.properties = new Properties();
        this.properties.load(Resources.getResourceAsStream("config.properties"));
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(is, "development", properties);
        this.session = factory.openSession();
        this.iDeptDao = this.session.getMapper(IDeptAnnotationDao.class);
        this.iEmployeeDao = this.session.getMapper(IEmployeeAnnotationDao.class);
    }

    @Test
    public void testSelect() throws IOException {
        Dept dept = this.iDeptDao.selectDept(27);
        logger.debug(dept.getEmployeeList());
        logger.debug(dept);
    }

    @Test
    public void testSelectField() throws IOException {
        Dept dept = new Dept();
        dept.setDepNo(27);
        Dept res = this.iDeptDao.selectField(dept);
        logger.debug(res);
    }

    @Test
    public void testFindEmployee() throws IOException {
        Employee emp = new Employee();
        emp.setEmpNo(5);
        Employee employee = this.iEmployeeDao.findByEmpNo(emp);
        logger.debug(employee);
    }

    @After
    public void clear() {
        session.close();
    }
}
