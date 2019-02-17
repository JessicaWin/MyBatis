import com.kaikeba.dao.IDeptDao;
import com.kaikeba.dao.impl.DeptDaoImpl;
import com.kaikeba.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDept {
  public static void main(String[] args) throws IOException {
    Dept dept = new Dept();
    dept.setDepName("test");
    dept.setLoc("shanghai");
    Properties properties = new Properties();
    properties.load(Resources.getResourceAsStream("config.properties"));
    InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
    SqlSessionFactory factory =
        new SqlSessionFactoryBuilder().build(is, "development2", properties);
      SqlSession session = factory.openSession();
      IDeptDao iDeptDao = session.getMapper(IDeptDao.class);
      iDeptDao.insertDept2(dept);
      session.commit();
      session.close();
    }
}
