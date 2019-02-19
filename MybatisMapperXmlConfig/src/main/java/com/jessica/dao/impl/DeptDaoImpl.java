package com.kaikeba.dao.impl;

import com.kaikeba.dao.IDeptDao;
import com.kaikeba.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class DeptDaoImpl implements IDeptDao {
    private  SqlSessionFactory factory;
    // 私有构造
    private DeptDaoImpl() {
        Properties properties = new Properties();
        try{
            properties.load(Resources.getResourceAsStream("config.properties"));
            InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(is, "development2", properties);
        } catch (IOException exception) {

        }
    }

    // 静态内部类
    private static class InnerObject{
        private static DeptDaoImpl instance = new DeptDaoImpl();
    }

    public static DeptDaoImpl getInstance() {
        return InnerObject.instance;
    }

    public void insert(Dept dept) throws IOException {
        SqlSession session = factory.openSession();
        session.insert("insertDept2",dept);
        session.commit();
        session.close();
    }

    public Dept findByNameAndLoc(String depName, String loc) {
        Dept key = Dept.builder().depName(depName).loc(loc).build();
        SqlSession session = factory.openSession();
        Dept dept = session.selectOne("find4", key);
        session.commit();
        session.close();
        return  dept;
    }

    public Dept findById(int depName) {
        Dept key = Dept.builder().depNo(depName).depName("test").build();
        SqlSession session = factory.openSession();
        Dept dept = session.selectOne("deptFindByDeptNo", key);
        session.commit();
        session.close();
        return  dept;
    }

    public List<Dept> findAll() {
        SqlSession session = factory.openSession();
        List<Dept> dept = session.selectList("findAll");
        session.commit();
        session.close();
        return  dept;
    }
}
