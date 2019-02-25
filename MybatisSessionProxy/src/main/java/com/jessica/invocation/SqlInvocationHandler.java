package com.jessica.invocation;

import com.jessica.session.SqlSession;
import com.mysql.cj.conf.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SqlInvocationHandler implements InvocationHandler {
    private SqlSession sqlSession;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public SqlInvocationHandler(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;
        init((String) args[0]);
        Field field = sqlSession.getClass().getDeclaredField("preparedStatement");
        field.setAccessible(true);
        field.set(sqlSession, this.preparedStatement);
        value = method.invoke(sqlSession, args);
        close();
        return value;
    }

    public void init(String sql) throws Exception{
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1121mysql");
        this.preparedStatement = connection.prepareStatement(sql);


    }

    public void close() throws Exception{
        if (connection != null) {
            preparedStatement.close();
            connection.close();
        }
    }
}
