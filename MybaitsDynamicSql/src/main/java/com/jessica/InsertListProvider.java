package com.jessica;

import com.jessica.entity.Dept;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class InsertListProvider {
    private final String DEPT_TABLE = "dept";

    public String insertDeptList(Map map) {
        List<Dept> deptList = (List<Dept>) map.get("list");
        if (deptList != null && deptList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO dept ");
            sb.append("(depName, loc)");
            sb.append("VALUES ");
            MessageFormat mf = new MessageFormat("(null, #'{'deptList[{0}].depName, #'{'deptList[{0}].loc})");
            for (int i = 0; i < deptList.size(); i++) {
                sb.append(mf.format(new Object[]{i}));
                if (i < deptList.size() - 1) {
                    sb.append(",");
                }
            }

            return sb.toString();
        }
        return null;
    }
}
