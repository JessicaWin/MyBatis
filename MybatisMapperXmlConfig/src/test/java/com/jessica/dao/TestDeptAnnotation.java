package com.jessica.dao;

import com.jessica.entity.Dept;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TestDeptAnnotation {
    private  Properties properties;
    private SqlSession session;
    private Logger logger = Logger.getLogger(TestDept.class);
    private IDeptAnnotationDao iDeptDao;
    @Before
    public void init() throws IOException {
        this.properties = new Properties();
        this.properties.load(Resources.getResourceAsStream("config.properties"));
        InputStream is = Resources.getResourceAsStream("MyBatisConfig2.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(is, "development", properties);
        this.session = factory.openSession();
        this.iDeptDao = this.session.getMapper(IDeptAnnotationDao.class);
    }

    @Test
    public void testinsert() throws IOException {
        Dept dept = new Dept();
        dept.setDepName("Accounting");
        dept.setLoc("NewYork");

        int res = this.iDeptDao.insert(dept);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testFindByNameAndLoc() throws IOException {
        Dept dept = new Dept();
        dept.setDepName("te");

        List<Dept> res = this.iDeptDao.findByNameAndLoc("Accounting", "NewYork");
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testFindById() throws IOException {
        Dept res = this.iDeptDao.findById(27);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testFindAll() throws  Exception {
        List<Dept> res = this.iDeptDao.findAll();
        session.commit();
        logger.debug(res);
    }
    @After
    public void clear() {
        session.close();
    }
}
