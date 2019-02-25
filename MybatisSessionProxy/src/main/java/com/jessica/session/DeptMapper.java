package com.jessica.session;

import java.sql.PreparedStatement;

public class DeptMapper implements SqlSession {
    private PreparedStatement preparedStatement;
    public int save(String sql) {
        try{
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
