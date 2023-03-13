package org.nilcux.ioc;


import org.dom4j.Element;
import org.nilcux.ioc.factory.BeanFactory;

public class XMLBeanDefinitionReader {
    BeanFactory beanFactory;
    public XMLBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBean(beanDefinition);
        }
    }
}