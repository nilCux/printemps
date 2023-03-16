package org.nilcux.ioc;


import org.dom4j.Element;
import org.nilcux.ioc.beanFactory.BeanFactory;
import org.nilcux.ioc.beanFactory.SimpleBeanFactory;

public class XMLBeanDefinitionReader {
    SimpleBeanFactory beanFactory;
    public XMLBeanDefinitionReader(SimpleBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}