package com.jessica;

import com.jessica.entity.Dept;
import org.apache.ibatis.jdbc.SQL;

public class UpdateDeptProvider {
    private final String DEPT_TABLE = "dept";

    public String updateDept(Dept dept) {
        SQL sql = new SQL().UPDATE(DEPT_TABLE);
        String depName = dept.getDepName();
        String loc = dept.getLoc();
        if  (depName != null && depName.length() > 0) {
            sql.SET("depName = #{depName}");
        }
        if (loc != null && loc.length() > 0) {
            sql.SET("loc = #{loc}");
        }
        sql.WHERE("depNo = #{depNo}");
        return  sql.toString();
    }
}
