package org.nilcux.ioc;


import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.beanFactory.BeanFactory;
import org.nilcux.ioc.beanFactory.SimpleBeanFactory;

public class ClassPathXMLApplicationContext implements BeanFactory{
    BeanFactory beanFactory;

    public ClassPathXMLApplicationContext(String fileName) {
        Resource resource = new ClassPathXMLResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeanException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public Boolean containsBean(String beanName) {
        return beanFactory.containsBean(beanName);
    }

    @Override
    public void registerBean(String beanName, Object bean) {
        this.beanFactory.registerBean(beanName, bean);
    }
}
