package com.jessica;

import com.jessica.entity.Dept;
import org.apache.ibatis.jdbc.SQL;

public class OneToManyProvider {
    private String deptTableName = "dept";

    public String generateSql(Dept dept) {
        SQL sql = new SQL().SELECT("*").FROM(deptTableName).WHERE("dept.depNo=#{depNo}");
        return  sql.toString();
    }
}
