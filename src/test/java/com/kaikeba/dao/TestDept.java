package com.kaikeba.dao;

import com.kaikeba.dao.IDeptDao;
import com.kaikeba.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDept {
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
  public void testInsert() throws IOException{
    Dept dept = new Dept();
    dept.setDepName("test");
    dept.setLoc("shanghai");

    IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
    iDeptDao.insertDept2(dept);
    session.commit();
  }

  @After
  public void clear() {
    session.close();
  }
}
