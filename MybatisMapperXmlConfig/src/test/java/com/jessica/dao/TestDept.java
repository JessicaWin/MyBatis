import com.kaikeba.dao.IDeptDao;
import com.kaikeba.dao.impl.DeptDaoImpl;
import com.kaikeba.entity.Dept;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class TestDept {
  public static void main(String[] args) throws IOException {
      Dept dept = new Dept();
      dept.setDepName("test");
      dept.setLoc("shanghai");

      IDeptDao iDeptDao = DeptDaoImpl.getInstance();
      List<Dept> deptAll = iDeptDao.findAll();
      Logger.getLogger(TestDept.class).debug(deptAll.size());
  }
}