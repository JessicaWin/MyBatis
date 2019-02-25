package com.jessica.proxy;

import com.jessica.dao.IDeptDao;
import com.jessica.entity.Dept;
import com.jessica.factory.SqlSessionFactory;
import com.jessica.session.DeptMapper;
import com.jessica.session.SqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDept {
  private Logger logger= Logger.getLogger(TestDept.class);

  @Test
  public void testSqlSession() throws Exception{
    SqlSession sqlSession = SqlSessionFactory.build(DeptMapper.class);
    Assert.assertEquals(1, sqlSession.save("insert into dept( depName, loc, flag) values( 'test', 'BeiJing', 1)"));
  }
}
