package org.nilcux.ioc;


import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.factory.BeanFactory;
import org.nilcux.ioc.factory.SimpleBeanFactory;

public class ClassPathXMLApplicationContext implements BeanFactory{
    BeanFactory beanFactory;

    public ClassPathXMLApplicationContext(String fileName) {
        Resource resource = new ClassPathXMLResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeanException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBean(BeanDefinition beanDefinition) {
        this.beanFactory.registerBean(beanDefinition);
    }
}
