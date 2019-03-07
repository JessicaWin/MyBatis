package com.jessica;

import com.jessica.entity.Dept;
import org.apache.ibatis.jdbc.SQL;

public class ParamProvider {
    private final String DEPT_TABLE = "dept";

    public  String queryDeptByParamChoose (Dept dept) {
        SQL sql = new SQL().SELECT("*").FROM(DEPT_TABLE);
        int depNo = dept.getDepNo();
        String depName = dept.getDepName();
        String loc = dept.getLoc();
        if (depNo > 0) {
            sql.WHERE("depNo = #{depNo}");
        } else if  (depName != null && depName.length() > 0) {
            sql.WHERE("depName like '%' #{depName} '%'");
        } else if (loc != null && loc.length() > 0) {
            sql.WHERE("loc like '%' #{loc} '%'");
        }
        return  sql.toString();
    }

    public  String queryDeptByParam (Dept dept) {
        SQL sql = new SQL().SELECT("*").FROM(DEPT_TABLE);
        int depNo = dept.getDepNo();
        String depName = dept.getDepName();
        String loc = dept.getLoc();
        if (depNo > 0) {
            sql.WHERE("depNo = #{depNo}");
        }
        if  (depName != null && depName.length() > 0) {
            sql.WHERE("depName like '%' #{depName} '%'");
        }
        if (loc != null && loc.length() > 0) {
            sql.WHERE("loc like '%' #{loc} '%'");
        }
        return  sql.toString();
    }
}
