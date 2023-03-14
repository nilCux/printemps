import org.junit.Test;
import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.ClassPathXMLApplicationContext;
import org.nilcux.ioc.XMLBeanDefinitionReader;
import org.nilcux.ioc.factory.BeanFactory;
import org.nilcux.ioc.factory.SimpleBeanFactory;

public class IoCTest {
    @Test
    public void test() {
        ClassPathXMLApplicationContext classPathXMLApplicationContext = new ClassPathXMLApplicationContext("beans.xml");

        AService aService;
        try {
            aService = (AService) classPathXMLApplicationContext.getBean("AService");
        } catch (BeanException e) {
            throw new RuntimeException(e);
        }
        aService.sayHello();
    }

}
