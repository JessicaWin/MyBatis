package com.jessica.dao;

import com.jessica.entity.Dept;
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
import java.util.List;
import java.util.Properties;

public class TestDeptAnnotation {
    private Properties properties;
    private SqlSession session;
    private Logger logger= Logger.getLogger(TestDept.class);
    private IDeptAnnotationDao iDeptAnnotationDao;
    @Before
    public void init() throws IOException {
        this.properties = new Properties();
        this.properties.load(Resources.getResourceAsStream("config.properties"));
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(is, "development", properties);
        this.session = factory.openSession();
        this.iDeptAnnotationDao =  session.getMapper(IDeptAnnotationDao.class);
    }

    @Test
    public void testInsert() throws IOException{
        Dept dept = new Dept();
        dept.setDepName("test");
        dept.setLoc("shanghai");
        dept.setFlag(true);
        this.iDeptAnnotationDao.insertDept(dept);
        dept.setFlag(false);
        this.iDeptAnnotationDao.insertDept(dept);
        session.commit();
    }

    @Test
    public void testFindByDeptNo() throws IOException{
        Dept dept = this.iDeptAnnotationDao.findByDeptNo(1);
        logger.debug(dept);
        dept = this.iDeptAnnotationDao.findByDeptNo(2);
        logger.debug(dept);
        session.commit();
    }

    @Test
    public void testFindAll() throws IOException{
        List<Dept> depts = this.iDeptAnnotationDao.findAll();
        logger.debug(depts);
        session.commit();
    }

    @After
    public void clear() {
        session.close();
    }
}
