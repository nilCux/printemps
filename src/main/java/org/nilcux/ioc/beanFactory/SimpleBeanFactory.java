package org.nilcux.ioc.beanFactory;

import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.BeanDefinition;
import org.nilcux.ioc.singleton.DefaultSingletonBeanRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{
    Map <String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public Object getBean(String beanName) throws BeanException {
        Object singletonInstance = this.getSingleton(beanName);

        if (singletonInstance == null) {
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);

            if (beanDefinition == null) {
                throw new BeanException("No bean named " + beanName + " is defined");
            }

            try {
                singletonInstance = Class.forName(beanDefinition.getClassName()).getConstructor().newInstance();
            } catch (Exception e) {
                throw new BeanException("Error creating bean " + beanName);
            }

           this.registerSingleton(beanName, singletonInstance);
        }

        return singletonInstance;
    }

    public void registerBean(String beanName, Object bean) {
        this.registerSingleton(beanName, bean);
    }

    @Override
    public Boolean containsBean(String beanName) {
        return containsSingleton(beanName);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) { this.beanDefinitions.put(beanDefinition.getId(), beanDefinition); }
}
