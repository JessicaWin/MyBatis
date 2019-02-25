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
import java.util.Properties;

public class TestDept {
  private Logger logger= Logger.getLogger(TestDept.class);
  private  Properties properties;
  private SqlSession session;
  @Before
  public void init() throws IOException {
    this.properties = new Properties();
    this.properties.load(Resources.getResourceAsStream("config.properties"));
    InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
    SqlSessionFactory factory =
            new SqlSessionFactoryBuilder().build(is, "development2", properties);
    this.session = factory.openSession();
  }

  @Test
  public void testSelectDept() throws IOException{
    IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
    Dept dept = iDeptDao.findByDeptNo(1);
    session.commit();
    logger.debug(dept);
  }

  @After
  public void clear() {
    session.close();
  }
}
