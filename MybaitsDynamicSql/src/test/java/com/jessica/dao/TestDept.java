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

public class TestDept {
    private  Properties properties;
    private SqlSession session;
    private Logger logger = Logger.getLogger(TestDept.class);
    private IDeptDao iDeptDao;
    @Before
    public void init() throws IOException {
        this.properties = new Properties();
        this.properties.load(Resources.getResourceAsStream("config.properties"));
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(is, "development", properties);
        this.session = factory.openSession();
        this.iDeptDao = this.session.getMapper(IDeptDao.class);
    }

    @Test
    public void testSelect1() throws IOException {
        Dept dept = new Dept();
        dept.setDepName("te");
        dept.setLoc("shanghai");

        List<Dept> res = this.iDeptDao.selectDept1(dept);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testSelect2() throws IOException {
        Dept dept = new Dept();
        dept.setDepName("te");

        List<Dept> res = this.iDeptDao.selectDept2(dept);
        session.commit();
        logger.debug(res);

        dept.setDepName("");
        dept.setLoc("shanghai");
        res = iDeptDao.selectDept2(dept);
        session.commit();
        logger.debug(res);

        dept.setLoc(null);
        dept.setDepNo(12);
        res = iDeptDao.selectDept2(dept);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testSelect3() throws IOException {
        Dept dept = new Dept();
        dept.setDepName("te");

        List<Dept> res = this.iDeptDao.selectDept3(dept);
        session.commit();
        logger.debug(res);

        dept.setLoc("shanghai");
        res = iDeptDao.selectDept3(dept);
        session.commit();
        logger.debug(res);

        dept.setDepNo(12);
        res = iDeptDao.selectDept3(dept);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testUpdateDept() throws  Exception {
        Dept dept = new Dept();
        dept.setDepNo(14);
        dept.setDepName("sales");
        int updateRow = this.iDeptDao.updateDept(dept);
        session.commit();
        logger.debug(updateRow);

        dept.setLoc("beijing");
        updateRow = this.iDeptDao.updateDept(dept);
        session.commit();
        logger.debug(updateRow);
    }


    @Test
    public void testSelectAll() throws IOException {
        List<Dept> res = this.iDeptDao.selectAll("dept");
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testFindTrim() throws IOException {
        Dept dept = new Dept();
        dept.setDepName("te");
        dept.setLoc("shanghai");
        List<Dept> res = this.iDeptDao.findTrim(dept);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testInsertForEach() throws IOException {
        List<Dept> res = new ArrayList<Dept>();
        Dept dept = new Dept();
        dept.setDepName("consultant");
        dept.setLoc("tokyo");
        res.add(dept);
        Dept dept1 = new Dept();
        dept1.setDepName("market");
        dept1.setLoc("beijing");
        res.add(dept1);

        int rows = this.iDeptDao.insertForEach(res);
        session.commit();
        logger.debug(rows);
    }

    @Test
    public void testFindByList() throws IOException {
        List<Integer> keyList = new ArrayList<Integer>();
        keyList.add(14);
        keyList.add(20);

        List<Dept> res = this.iDeptDao.findByList( keyList);
        session.commit();
        logger.debug(res);
    }

    @Test
    public void testFindByArray() throws IOException {
        Integer[] keyArray = new Integer[]{4,20};
        List<Dept> res = this.iDeptDao.findByArray( keyArray);
        session.commit();
        logger.debug(res);
    }


    @Test
    public void testFindByMap() throws IOException {
        Map<String, Integer> keyMap = new HashMap<String, Integer>();
        keyMap.put("key1", 4);
        keyMap.put("key2", 20);
        List<Dept> res = this.iDeptDao.findByMap( keyMap);
        session.commit();
        logger.debug(res);
    }

    @After
    public void clear() {
        session.close();
    }
}
