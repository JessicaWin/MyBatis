package com.jessica.dao;

import com.jessica.entity.Dept;
import com.jessica.handler.BooleanTypeHandler;
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

public class TestDept {
  private  Properties properties;
  private SqlSession session;
  private  Logger logger= Logger.getLogger(TestDept.class);
  @Before
  public void init() throws IOException {
    this.properties = new Properties();
    this.properties.load(Resources.getResourceAsStream("config.properties"));
    InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
    SqlSessionFactory factory =
            new SqlSessionFactoryBuilder().build(is, "development", properties);
    this.session = factory.openSession();
  }

  @Test
  public void testFindByDeptNo() throws IOException{
    IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
    Dept dept = iDeptDao.findByDeptNo(8);
    logger.debug(dept);
    dept = iDeptDao.findByDeptNo(10);
    logger.debug(dept);
    session.commit();
  }

  @Test
  public void testFindAll() throws IOException{
    IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
    List<Dept> depts = iDeptDao.findAll();
    logger.debug(depts);
    session.commit();
  }

  @Test
  public void testInsert() throws IOException{
    Dept dept = new Dept();
    dept.setDepName("test2");
    dept.setLoc("shanghai");
    dept.setFlag(true);
    IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
    iDeptDao.insertDept(dept);
    session.commit();
  }

  @After
  public void clear() {
    session.close();
  }
}
