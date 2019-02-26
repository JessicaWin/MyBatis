package com.jessica.dao;

import com.jessica.entity.Dept;
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
import java.util.List;
import java.util.Properties;

public class TestDept {
  private  Properties properties;
  private SqlSession session;
  private Logger logger = Logger.getLogger(TestDept.class);
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
  public void testInsert() throws IOException{
    Dept dept = new Dept();
    dept.setDepName("test");
    dept.setLoc("shanghai");

    IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
    iDeptDao.insertDept2(dept);
    session.commit();
  }

  @Test
    public void testSelect2() throws IOException{
        Dept dept = new Dept();
        dept.setDepName("test");
        dept.setLoc("shanghai");

        IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
        List<Dept> res = iDeptDao.selectDept2(dept);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testSelectAll() throws IOException{

        IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
        List<Dept> res = iDeptDao.selectAll("dept2");
        session.commit();
        logger.debug(res);
    }

  @After
  public void clear() {
    session.close();
  }
}
