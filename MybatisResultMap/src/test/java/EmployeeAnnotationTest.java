import com.jessica.dao.IEmployeeAnnotationDao;
import com.jessica.dao.IEmployeeDao;
import com.jessica.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

public class EmployeeAnnotationTest {
    private Properties properties;
    private SqlSession session;
    private IEmployeeAnnotationDao iEmployeeDao;
    private Logger logger= Logger.getLogger(EmployeeAnnotationTest.class);
    @Before
    public void init() throws IOException {
        this.properties = new Properties();
        this.properties.load(Resources.getResourceAsStream("config.properties"));
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(is, "development", properties);
        this.session = factory.openSession();
        this.iEmployeeDao = session.getMapper(IEmployeeAnnotationDao.class);
    }

    @Test
    public void testInsert() throws  Exception{
        Date hireDate = Date.valueOf("2016-02-24");
        Employee employee = new Employee();
        employee.setEName("Mike");
        employee.setDal("dal");
        employee.setJob("Software Developer");
        employee.setHireDate(hireDate);
        try{
            iEmployeeDao.insertEmployee(employee);
            this.session.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testFindByEmpNo() throws  Exception{
        Employee employee = this.iEmployeeDao.findByEmpNo(5);
        this.session.commit();
        logger.debug(employee);
    }
    @Test
    public void testFindAllEmp() throws  Exception{
        List<Employee> employeeList = this.iEmployeeDao.findAllEmp();
        this.session.commit();
        logger.debug(employeeList);
    }

    @After
    public void clear() {
        session.close();
    }
}
