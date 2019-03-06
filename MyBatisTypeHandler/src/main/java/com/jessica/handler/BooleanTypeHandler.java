package com.jessica.handler;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Boolean.class)
public class BooleanTypeHandler implements TypeHandler {
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if(parameter == null) {
            Logger.getLogger(BooleanTypeHandler.class).debug("parameter is null");
            ps.setInt(i,0);
            return;
        }
        Boolean flag = (Boolean) parameter;
        Logger.getLogger(BooleanTypeHandler.class).debug("parameter is" + flag.toString());
        Integer val = flag ? 1:0;
        ps.setInt(i,val);
    }

    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        int flag = rs.getInt(columnName);
        Boolean res = Boolean.FALSE;
        if (flag == 1) {
            res = Boolean.TRUE;
        }
        return res;
    }

    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        int flag = rs.getInt(columnIndex);
        Boolean res = Boolean.FALSE;
        if (flag == 1) {
            res = Boolean.TRUE;
        }
        return res;
    }

    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int flag = cs.getInt(columnIndex);
        Boolean res = Boolean.FALSE;
        if (flag == 1) {
            res = Boolean.TRUE;
        }
        return res;
    }
}
