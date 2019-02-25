package com.jessica.factory;

import com.jessica.invocation.SqlInvocationHandler;
import com.jessica.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SqlSessionFactory {
    public  static SqlSession build(Class classField) throws Exception {
        SqlSession sqlSession = (SqlSession)classField.newInstance();
        InvocationHandler invocationHandler = new SqlInvocationHandler(sqlSession);
        return (SqlSession) Proxy.newProxyInstance(sqlSession.getClass().getClassLoader(), sqlSession.getClass().getInterfaces(), invocationHandler);
    }
}
