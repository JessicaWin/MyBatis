import com.jessica.dao.BasicService;
import com.jessica.dao.impl.Persion;
import com.jessica.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy() throws Exception {
        BasicService basicService = ProxyFactory.create(Persion.class);
        basicService.eat();
        basicService.wc();
    }
}
